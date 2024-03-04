package com.mozhimen.uicorek.test.btnk

import android.os.Bundle
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.uicorek.test.databinding.ActivityBtnkBinding

class BtnKActivity : BaseActivityVDB<ActivityBtnkBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vdb.btnkPwdVisible.bindEditText(vdb.btnkPwdVisibleEdit)
    }
}