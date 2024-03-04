package com.mozhimen.uicorek.test.popwink

import android.view.View
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.uicorek.test.databinding.ActivityPopwinkBinding
import com.mozhimen.uicorek.test.popwink.temps.PopwinKAnim
import com.mozhimen.uicorek.test.popwink.temps.PopwinKSelector
import com.mozhimen.uicorek.test.popwink.temps.PopwinKTest


/**
 * @ClassName PopwinKActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/17 16:45
 * @Version 1.0
 */
class PopwinKActivity : BaseActivityVDB<ActivityPopwinkBinding>() {

    private val _popwinK by lazy { PopwinKAnim(this) }
    fun showPopwinK(view: View) {
        _popwinK.showPopupWindow()
    }

    private val _popwinKTest by lazy { PopwinKTest(this, "inited") }
    fun showPopwinKTest(view: View) {
        _popwinKTest.showPopupWindow()
    }

    private val _popwinKSelector by lazy { PopwinKSelector(this, mutableListOf("1", "2", "3")) }
    fun showPopwinKSelectorNormal(view: View) {
        if (_popwinKSelector.isShowing) _popwinKSelector.dismiss()
        _popwinKSelector.setItems(listOf("Java", "Kotlin", "ObjectC", "Swift", "Dart", "C#", "C++", "C", "Python"))
        _popwinKSelector.showPopupWindow()
    }

    fun showPopwinKSelectorName(view: View) {
        if (_popwinKSelector.isShowing) _popwinKSelector.dismiss()
        _popwinKSelector.setItems(listOf("上海", "北京", "广州", "深圳", "苏州", "无锡", "杭州", "常州", "南通", "嘉兴"))
        _popwinKSelector.showPopupWindow()
    }
}