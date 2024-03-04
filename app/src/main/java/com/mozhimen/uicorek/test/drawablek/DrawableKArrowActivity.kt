package com.mozhimen.uicorek.test.drawablek

import android.graphics.Color
import android.os.Bundle
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.basick.utilk.android.util.dp2px
import com.mozhimen.basick.utilk.android.content.UtilKRes
import com.mozhimen.uicorek.drawablek.arrow.DrawableKArrow
import com.mozhimen.uicorek.drawablek.arrow.cons.EArrowDirection
import com.mozhimen.uicorek.drawablek.arrow.cons.EArrowPosPolicy
import com.mozhimen.uicorek.test.databinding.ActivityDrawablekArrowBinding

class DrawableKArrowActivity : BaseActivityVDB<ActivityDrawablekArrowBinding>() {
    private var drawableKArrow: DrawableKArrow? = null
        get() {
            if (field != null) return field
            val drawableKArrow = DrawableKArrow()
            drawableKArrow.apply {
                resetRect(vdb.drawablekArrow1.width, vdb.drawablekArrow1.height)

                setFillColor(Color.BLACK)
                setGapWidth(5f.dp2px())
                setCornerRadius(10f.dp2px())

                setBorderWidth(3f.dp2px())
                setBorderColor(UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_287ff1))

                setArrowWidth(20f.dp2px())
                setArrowHeight(10f.dp2px())
                setArrowDirection(EArrowDirection.Left)
                setArrowPosPolicy(EArrowPosPolicy.TargetCenter)
                setArrowToPoint(30f, 30f)
                setArrowPosDelta(20f)

                updateShapes()
            }
            return drawableKArrow.also { field = it }
        }

    override fun initView(savedInstanceState: Bundle?) {
        vdb.drawablekArrow1.post {
            vdb.drawablekArrow1.background = drawableKArrow
        }
    }
}