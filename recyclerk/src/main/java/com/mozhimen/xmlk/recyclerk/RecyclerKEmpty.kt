package com.mozhimen.xmlk.recyclerk

import android.content.Context
import android.util.AttributeSet
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName RecyclerKEmpty
 * @Description TODO
 * @Author mozhimen
 * @Version 1.0
 */
class RecyclerKEmpty @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RecyclerView(context, attrs, defStyleAttr), IUtilK {

    private var _emptyView: View? = null
    private val _adapterDataObserver: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            checkIfEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            UtilKLogWrapper.d(TAG, "onItemRangeInserted $itemCount")
            checkIfEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            UtilKLogWrapper.d(TAG, "onItemRangeRemoved clear")
            checkIfEmpty()
        }
    }

    private fun checkIfEmpty() {
        if (_emptyView != null && adapter != null) {
            val emptyViewVisible = adapter!!.itemCount == 0
            _emptyView!!.visibility = if (emptyViewVisible) VISIBLE else GONE
            visibility = if (emptyViewVisible) GONE else VISIBLE
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(_adapterDataObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(_adapterDataObserver)
        checkIfEmpty()
    }

    //设置没有内容时，提示用户的空布局
    /**
     * 作用: 设置空布局
     * 用法:  emptyView=findViewById(R.id.item_empty)
     * vdb.recycler.setEmptyView(emptyView)
     */
    fun setEmptyView(emptyView: View?) {
        this._emptyView = emptyView
        checkIfEmpty()
    }
}