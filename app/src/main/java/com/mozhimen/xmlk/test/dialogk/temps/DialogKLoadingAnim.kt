package com.mozhimen.xmlk.test.dialogk.temps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mozhimen.animk.builder.impls.AnimationRotationRecyclerType
import com.mozhimen.kotlin.utilk.android.widget.applyValueIfNotEmpty
import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone
import com.mozhimen.kotlin.utilk.wrapper.stopAnim
import com.mozhimen.xmlk.dialogk.bases.BaseDialogK
import com.mozhimen.xmlk.dialogk.bases.commons.IDialogKClickListener
import com.mozhimen.xmlk.test.R

/**
 * @ClassName LoadingDialog
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
class DialogKLoadingAnim @JvmOverloads internal constructor(context: Context, private var _desc: String? = null) : BaseDialogK<IDialogKClickListener>(context) {
    private var _imgProgress: ImageView? = null
    private var _txtDesc: TextView? = null
    private val _rotateAnimation by lazy_ofNone { AnimationRotationRecyclerType().setDuration(1000).build() }

    init {
        setDialogCancelable(true)
        setOnDismissListener {
            _imgProgress?.stopAnim()
        }
        setOnShowListener {
            _imgProgress?.startAnimation(_rotateAnimation)
        }
    }

    companion object {
        @JvmOverloads
        fun create(context: Context, desc: String? = null): DialogKLoadingAnim {
            return DialogKLoadingAnim(context, desc)
        }
    }

    override fun onCreateView(inflater: LayoutInflater): View {
        return inflater.inflate(R.layout.dialogk_loading_anim, null)
    }

    override fun onViewCreated(view: View) {
        _imgProgress = view.findViewById(R.id.dialogk_loading_img_progress)
        _txtDesc = view.findViewById(R.id.dialogk_loading_txt_desc)
        setDesc(_desc)
    }

    fun setDesc(desc: String?) {
        _txtDesc?.applyValueIfNotEmpty(desc)
    }
}