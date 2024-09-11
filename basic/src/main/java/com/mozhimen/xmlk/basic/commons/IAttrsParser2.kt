package com.mozhimen.xmlk.basic.commons

import android.content.Context
import android.util.AttributeSet


/**
 * @ClassName BaseAttrsParser2
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/17 18:27
 * @Version 1.0
 */
interface IAttrsParser2<M> {
    fun parseAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int): M
}