package com.mozhimen.xmlk.test.dialogk.temps

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.util.dp2px
import com.mozhimen.xmlk.test.R

/**
 * @ClassName DialogKQues
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
class DialogKQues @JvmOverloads constructor(context: Context, themeId: Int = 0) : Dialog(context, themeId) {

    class Builder(private val _context: Context) : IDialogKBuilder {

        //region # variate
        private lateinit var _bg: FrameLayout
        private lateinit var _titleView: TextView
        private lateinit var _btnCancel: MaterialButton
        private lateinit var _btnSure: MaterialButton

        private var _title: String = "请替换你的问题!"
        //endregion

        override var layoutId: Int = R.layout.dialogk_ques
        override var width: Float = 300f
        override var height: Float = 120f
        override var layoutParams: ViewGroup.LayoutParams =
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        override var animStyleId: Int? = null
        override var styleId: Int = com.mozhimen.xmlk.R.style.ThemeK_Dialog_Fullscreen
        override var cancelable: Boolean = true

        fun setQuestion(title: String): Builder {
            this._title = title
            return this
        }

        fun genBackground(block: IExt_Listener<FrameLayout>) {
            _bg.block()
        }

        fun genTitle(block: IExt_Listener<TextView>) {
            _titleView.block()
        }

        fun genBtnCancel(block: IExt_Listener<MaterialButton>) {
            _btnCancel.block()
        }

        fun genBtnSure(block: IExt_Listener<MaterialButton>) {
            _btnSure.block()
        }

        fun create(onSureClick: I_Listener? = null, onCancelClick: I_Listener? = null): DialogKQues {
            val layoutInflater = UtilKContext.getLayoutInflater(_context)
            val dialogKQues = DialogKQues(_context, styleId)
            val view = layoutInflater.inflate(layoutId, null)
            dialogKQues.addContentView(
                view, layoutParams
            )

            _bg = view.findViewById(R.id.dialogk_ques_bg)
            _titleView = view.findViewById(R.id.dialogk_ques_title)
            _titleView.text = _title
            _btnCancel = view.findViewById(R.id.dialogk_ques_btn_cancel)
            _btnSure = view.findViewById(R.id.dialogk_ques_btn_sure)

            _btnCancel.setOnClickListener {
                dialogKQues.dismiss()
                onCancelClick?.invoke()
            }
            _btnSure.setOnClickListener {
                dialogKQues.dismiss()
                onSureClick?.invoke()
            }
            dialogKQues.setContentView(view)
            dialogKQues.setCancelable(cancelable)
            dialogKQues.window?.setWindowAnimations(animStyleId ?: com.mozhimen.animk.R.style.AnimK_Theme_Alpha)
            dialogKQues.window?.setLayout(width.dp2px().toInt(), height.dp2px().toInt())
            return dialogKQues
        }
    }
}