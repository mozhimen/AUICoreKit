package com.mozhimen.xmlk.viewk.helpers

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.mozhimen.kotlin.utilk.android.view.UtilKView
import com.mozhimen.kotlin.utilk.android.view.UtilKViewWrapper

/**
 * @ClassName ViewKBindingAdapter
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 14:16
 * @Version 1.0
 */
object ViewKBindingAdapter {
    @JvmStatic
    @BindingAdapter("applyVisibilityShowHide")
    fun applyVisibilityShowHide(view: View, visibility: Boolean) {
        UtilKViewWrapper.applyVisibleIfElseInVisible(view, visibility)
    }

    @JvmStatic
    @BindingAdapter("applyVisibilityShowGone")
    fun applyVisibleIfElseGone(view: View, visibility: Boolean) {
        UtilKViewWrapper.applyVisibleIfElseGone(view, visibility)
    }

    /**
     * 根据View的高度和宽高比, 设置高度
     * @param view View
     * @param viewRatio Float
     */
    @JvmStatic
    @BindingAdapter("viewRatio")
    fun applyViewRatio(view: View, viewRatio: Float) {
        UtilKViewWrapper.applyViewRatio(view, viewRatio)
    }

    @JvmStatic
    @BindingAdapter(value = ["loadBackgroundColorWhen", "loadBackgroundColorWhen_statusTrue", "loadBackgroundColorWhen_statusFalse"], requireAll = true)
    fun loadBackgroundColorWhen(view: View, boolean: Boolean, @ColorInt loadBackgroundColorWhen_statusTrue: Int, @ColorInt loadBackgroundColorWhen_statusFalse: Int) {
        if (boolean) {
            view.setBackgroundColor(loadBackgroundColorWhen_statusTrue)
        } else {
            view.setBackgroundColor(loadBackgroundColorWhen_statusFalse)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["loadBackgroundResourceWhen", "loadBackgroundResourceWhen_statusTrue", "loadBackgroundResourceWhen_statusFalse"], requireAll = true)
    fun loadBackgroundResourceWhen(view: View, boolean: Boolean, @DrawableRes loadBackgroundResourceWhen_statusTrue: Int, @DrawableRes loadBackgroundResourceWhen_statusFalse: Int) {
        if (boolean) {
            view.setBackgroundResource(loadBackgroundResourceWhen_statusTrue)
        } else {
            view.setBackgroundResource(loadBackgroundResourceWhen_statusFalse)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["loadBackgroundDrawableWhen", "loadBackgroundDrawableWhen_statusTrue", "loadBackgroundDrawableWhen_statusFalse"], requireAll = true)
    fun loadBackgroundDrawableWhen(view: View, boolean: Boolean, loadBackgroundDrawableWhen_statusTrue: Drawable, loadBackgroundDrawableWhen_statusFalse: Drawable) {
        if (boolean) {
            view.background = loadBackgroundDrawableWhen_statusTrue
        } else {
            view.background = loadBackgroundDrawableWhen_statusFalse
        }
    }
}