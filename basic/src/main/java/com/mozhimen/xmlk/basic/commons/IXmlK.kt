package com.mozhimen.xmlk.basic.commons

import android.util.AttributeSet
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName IXmlK
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2021/12/7 18:16
 * @Version 1.0
 */
interface IXmlK : IUtilK {
    fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int) {}
    fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {}
    fun initAttrs(attrs: AttributeSet?) {}
    fun initView() {}
}