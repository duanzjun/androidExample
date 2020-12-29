package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.R
import com.android.layout.bean.CommonItemModel

class CommonItemAdapter(mCommonItemList: MutableList<CommonItemModel>) :
    RecyclerView.Adapter<CommonItemAdapter.CommonItemHolder>() {

    private val mCommonItemList: MutableList<CommonItemModel> = mCommonItemList


    class CommonItemHolder(it: View) : RecyclerView.ViewHolder(it) {

        val mTitleItem: TextView = it.findViewById(R.id.tv_title_item)
//        val mContent: ImageView = it.findViewById(R.id.tv_image_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonItemHolder = (
            CommonItemHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_common_item_view, parent, false)
            )
            )

    override fun onBindViewHolder(holder: CommonItemHolder, position: Int) {
        if (mCommonItemList != null) {
            val mCommonItemModel: CommonItemModel = mCommonItemList[position]
            holder.mTitleItem.text = mCommonItemModel.title
        }
    }

    override fun getItemCount(): Int = mCommonItemList.size

}