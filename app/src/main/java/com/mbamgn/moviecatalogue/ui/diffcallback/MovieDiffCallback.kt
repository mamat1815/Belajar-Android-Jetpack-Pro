package com.mbamgn.moviecatalogue.ui.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.mbamgn.moviecatalogue.model.DataItem

class MovieDiffCallback(private val mOldDataItemList: List<DataItem>, private val mNewDataItemList: List<DataItem>):DiffUtil.Callback() {
    override fun getOldListSize(): Int = mOldDataItemList.size
    override fun getNewListSize(): Int = mNewDataItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldDataItemList[oldItemPosition].title == mNewDataItemList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldList = mOldDataItemList[oldItemPosition]
        val newList = mNewDataItemList[newItemPosition]

        return oldList.title == newList.title
    }


}