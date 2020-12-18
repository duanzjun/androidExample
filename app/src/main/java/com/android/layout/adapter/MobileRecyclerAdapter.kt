package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.bean.GoodsInfo
import com.android.layout.R

class MobileRecyclerAdapter(private val goodsList: List<GoodsInfo>) :
    RecyclerView.Adapter<MobileRecyclerAdapter.ViewHolder>() {

    private var mGoodsList: List<GoodsInfo> = goodsList


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_pic: ImageView = view.findViewById(R.id.iv_pic)
        val tv_desc: TextView = view.findViewById(R.id.tv_desc)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_mobile, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mGoods = mGoodsList[position]
        holder.iv_pic.setImageResource(mGoods.pic)
        holder.tv_desc.text = mGoods.desc
    }

    override fun getItemCount(): Int = mGoodsList.size
}