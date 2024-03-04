package com.mozhimen.uicorek.test.dialogk

import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.basick.elemk.commons.I_Listener
import com.mozhimen.basick.utilk.android.widget.showToast
import com.mozhimen.uicorek.test.dialogk.temps.DialogKLoadingAnim
import com.mozhimen.uicorek.test.dialogk.temps.DialogKLoadingAnimDrawable
import com.mozhimen.uicorek.test.dialogk.temps.DialogKQues
import com.mozhimen.uicorek.test.R
import com.mozhimen.uicorek.test.databinding.ActivityDialogkBinding
import com.mozhimen.uicorek.test.dialogk.temps.DialogKLoadingUpdate
import com.mozhimen.uicorek.test.dialogk.temps.DialogKTipVB
import com.mozhimen.uicorek.test.dialogk.temps.IDialogKTipListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DialogKActivity : BaseActivityVDB<ActivityDialogkBinding>() {

    fun goDialogKQues(view: View) {
        genDialogKQues("你get到此用法了吗?", onSureClick = {})
    }

    fun goDialogKQuesAnim(view: View) {
        genDialogKQuesAnim("带弹出动画的毛玻璃效果的弹框~")
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private var _dialogKQues: DialogKQues? = null
    private fun genDialogKQues(ques: String, onSureClick: I_Listener, onCancelClick: I_Listener? = null) {
        _dialogKQues?.dismiss()
        val builder = DialogKQues.Builder(this).setQuestion(title = ques)
        _dialogKQues = builder.create(onSureClick, onCancelClick)
        _dialogKQues!!.show()
    }

    private fun genDialogKQuesAnim(ques: String, onSureClick: I_Listener? = null, onCancelClick: I_Listener? = null) {
        _dialogKQues?.dismiss()
        val builder = DialogKQues.Builder(this)
        builder.apply {
            setQuestion(title = ques)
            animStyleId = R.style.DialogKQues_Anim_Custom
        }
        _dialogKQues = builder.create(onSureClick, onCancelClick)
        builder.genBackground {
            background.alpha = 200
        }
        _dialogKQues!!.show()
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    fun goDialogKCustomAnimDrawable(view: View) {
        showDialogLoadingAnimDrawable()
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private var _dialogkLoadingAnimDrawable: DialogKLoadingAnimDrawable? = null

    fun showDialogLoadingAnimDrawable() {
        if (_dialogkLoadingAnimDrawable == null) {
            _dialogkLoadingAnimDrawable = DialogKLoadingAnimDrawable.create(this)
        }
        _dialogkLoadingAnimDrawable!!.show()
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    fun goDialogLoadingAnim(view: View) {
        showDialogLoadingAnim()
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private var _dialogkLoadingAnim: DialogKLoadingAnim? = null

    fun showDialogLoadingAnim() {
        if (_dialogkLoadingAnim == null) {
            _dialogkLoadingAnim = DialogKLoadingAnim.create(this)
        }
        _dialogkLoadingAnim!!.show()
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    fun goDialogKCustomUpdate(view: View) {
        showLoadingUpdateDialog("正在更新", "...")
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private var _dialogKLoadingUpdate: DialogKLoadingUpdate? = null

    fun showLoadingUpdateDialog(desc: String, descUpdate: String) {
        if (_dialogKLoadingUpdate == null) {
            _dialogKLoadingUpdate = DialogKLoadingUpdate.create(this@DialogKActivity, desc, descUpdate).apply {
                setOnDismissListener {
                    // _isProcessingUpdate = false
                    Log.d(TAG, "showLoadingUpdateDialog: dismiss")
                }
            }
        } else {
            _dialogKLoadingUpdate!!.setDesc(desc)
            _dialogKLoadingUpdate!!.setUpdateDesc(descUpdate)
        }
        _dialogKLoadingUpdate!!.show()
    }

    fun updateLoadingUpdateDialog(str: String) {
        if (_dialogKLoadingUpdate != null && _dialogKLoadingUpdate!!.isShowing) {
            lifecycleScope.launch(Dispatchers.Main) {
                _dialogKLoadingUpdate!!.setUpdateDesc(str)
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    fun goDialogTipVb(view: View) {
        //如此使用
        showDialogTip("你提出的问题,亲?") {
            ///////////////////////////
            "你点击了确定".showToast()
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private var _dialogKTipVB: DialogKTipVB? = null

    fun showDialogTip(txt: String, onSure: IDialogKTipListener) {
        if (_dialogKTipVB == null)
            _dialogKTipVB = DialogKTipVB.create(this, txt, onSure)
        else _dialogKTipVB!!.apply {
            setTxt(txt)
            setOnSureListener(onSure)
        }
            _dialogKTipVB!!.show()
    }

    private fun dismissTipsVertical() {
            _dialogKTipVB?.dismiss()
    }

}