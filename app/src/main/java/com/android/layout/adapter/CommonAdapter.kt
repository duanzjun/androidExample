package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.R
import com.android.layout.bean.CommonItemModel
import com.android.layout.bean.CommonModel

class CommonAdapter(mCommonList: MutableList<CommonModel>) :
    RecyclerView.Adapter<CommonAdapter.CommonHolder>() {

    private val mCommonList: MutableList<CommonModel> = mCommonList


    class CommonHolder(it: View) : RecyclerView.ViewHolder(it) {
        val mTitle: TextView = it.findViewById(R.id.tv_title)
        val mCommonList: RecyclerView = it.findViewById(R.id.rv_common_list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHolder =
        CommonHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_common_view, parent, false)
        )

    override fun onBindViewHolder(holder: CommonHolder, position: Int) {
        if (mCommonList != null) {
            val mCommonModel = mCommonList[position]
            holder.mTitle.text = mCommonModel.title
            if (mCommonModel.contnetList != null) {
                holder.mCommonList.layoutManager = GridLayoutManager(holder.itemView.context, 4)
                holder.mCommonList.adapter = CommonItemAdapter(mCommonModel.contnetList as MutableList<CommonItemModel>)
            }
        }
    }

    override fun getItemCount(): Int = mCommonList.size
}