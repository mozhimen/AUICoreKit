package com.mozhimen.xmlk.test.recyclerk.mos

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.kotlin.utilk.android.util.dp2px
import com.mozhimen.kotlin.utilk.android.widget.applyFitDrawable_ofFit
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import com.mozhimen.xmlk.recyclerk.item.RecyclerKItem
import com.mozhimen.xmlk.test.R

/**
 * @ClassName DataKItemTop
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/4/21 23:29
 * @Version 1.0
 */
class RecyclerKItemTop : RecyclerKItem<RecyclerView.ViewHolder>() {
    private var _parentWidth: Int = 0

    override fun onBindItem(holder: RecyclerView.ViewHolder, position: Int) {
        super.onBindItem(holder, position)
        val imageView = holder.itemView as ImageView
        /*data?.let {
            if (data!!.title != null && !TextUtils.isEmpty(data!!.title!!)) {*/
        imageView.applyFitDrawable_ofFit(UtilKRes.gainDrawable(R.drawable.datak_item_top)!!)
        imageView.setImageResource(R.drawable.datak_item_top)
    }

    override fun getItemView(parent: ViewGroup): View {
        val imageView = ImageView(parent.context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setBackgroundColor(UtilKRes.gainColor(android.R.color.white))
        return imageView
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        //提前给imageview 预设一个高度值  等于parent的宽度
        _parentWidth = (holder.itemView.parent as ViewGroup).measuredWidth
        val params = holder.itemView.layoutParams
        if (params.width != _parentWidth) {
            params.width = _parentWidth
            params.height = 40.dp2px().toInt()
            holder.itemView.layoutParams = params
        }
    }

    override fun getItemSpanSize(): Int {
        return 2
    }
}

