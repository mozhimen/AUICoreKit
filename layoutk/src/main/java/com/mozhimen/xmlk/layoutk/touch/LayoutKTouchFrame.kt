package com.mozhimen.xmlk.layoutk.touch

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.xmlk.bases.BaseLayoutKFrame

/**
 * @ClassName ViewKTouch
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/9/8 18:05
 * @Version 1.0
 */
typealias ILayoutKTouchFrameListener = I_Listener

class LayoutKTouchFrame @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    BaseLayoutKFrame(context, attrs, defStyleAttr) {
    //region # variate
    private var _viewKTouchListener: ILayoutKTouchFrameListener? = null
    private var _touchAreaRect: Rect? = null
    //endregion

    /**
     * 触摸的区域范围(内)
     * @param areaRect Rect
     */
    fun setTouchArea(areaRect: Rect) {
        _touchAreaRect = areaRect
    }

    /**
     * 设置出发监听器
     * @param listener Function0<Unit>
     */
    fun setOnTouchListener(listener: ILayoutKTouchFrameListener) {
        _viewKTouchListener = listener
    }

    init {
        initFlag()
    }

    override fun initFlag() {
        setBackgroundColor(Color.TRANSPARENT)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        _touchAreaRect ?: return false
        val touchX = event.x
        val touchY = event.y
        if (touchX >= _touchAreaRect!!.left && touchX <= _touchAreaRect!!.right && touchY >= _touchAreaRect!!.top && touchY <= _touchAreaRect!!.bottom) {
            return false
        } else if (event.action == MotionEvent.ACTION_UP) {
            _viewKTouchListener?.invoke()
        }
        return true
    }
}