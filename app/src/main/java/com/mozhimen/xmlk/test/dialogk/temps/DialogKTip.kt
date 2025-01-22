package com.mozhimen.xmlk.test.dialogk.temps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.widget.applyValueIfNotEmpty
import com.mozhimen.kotlin.utilk.wrapper.UtilKScreen
import com.mozhimen.xmlk.dialogk.bases.BaseDialogK
import com.mozhimen.xmlk.dialogk.bases.commons.IDialogKClickListener
import com.mozhimen.xmlk.test.R
import kotlin.math.roundToInt

typealias IDialogKTipListener = I_Listener

class DialogKTip(context: Context, private val _txt: String, private var _onSure: IDialogKTipListener) : BaseDialogK<IDialogKClickListener>(context) {

    companion object {
        @JvmStatic
        fun create(context: Context, txt: String, onSure: IDialogKTipListener): DialogKTip {
            return DialogKTip(context, txt, onSure)
        }
    }

    private var _btnSure: Button? = null
    private var _btnCancel: Button? = null
    private var _txtView: TextView? = null

    init {
        setDialogCancelable(true)
        setDialogClickListener(object : IDialogKClickListener {
            override fun <I : IDialogKClickListener> onClickPositive(view: View?, dialogK: BaseDialogK<I>) {
                _onSure.invoke()
                this@DialogKTip.dismiss()
            }

            override fun <I : IDialogKClickListener> onClickNegative(view: View?, dialogK: BaseDialogK<I>) {
                this@DialogKTip.dismiss()
            }
        })
    }

    fun setTxt(txt: String) {
        _txtView?.applyValueIfNotEmpty(txt)
    }

    fun setSureListener(onSure: IDialogKTipListener) {
        _onSure = onSure
    }

    override fun onCreateView(inflater: LayoutInflater): View? {
        return inflater.inflate(R.layout.dialogk_tip, null)
    }

    override fun onViewCreated(view: View) {
        _txtView = view.findViewById(R.id.dialogk_tip_txt)
        _btnSure = view.findViewById(R.id.dialogk_tip_btn_sure)
        _btnCancel = view.findViewById(R.id.dialogk_tip_btn_cancel)

        _btnSure?.setOnClickListener { getDialogClickListener()?.onClickPositive(view, this) }
        _btnCancel?.setOnClickListener { getDialogClickListener()?.onClickNegative(view, this) }
        setTxt(_txt)
    }

    override fun getDialogWindowWidth(): Int {
        return (UtilKScreen.getWidth_ofDisplayMetrics_ofSys() * 0.25f).roundToInt()
    }
}