package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.R
import com.android.layout.bean.RecyclerInfo

class RecyclerLinearAdapter(infos: MutableList<RecyclerInfo>) :
    RecyclerView.Adapter<RecyclerLinearAdapter.ViewHolder>() {

    private val mInfos = infos

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var ll_item = v.findViewById<LinearLayout>(R.id.ll_item)
        var iv_pic = v.findViewById<ImageView>(R.id.iv_pic)
        var tv_title = v.findViewById<TextView>(R.id.tv_title)
        var tv_desc = v.findViewById<TextView>(R.id.tv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_linear, parent, false)
        val holder = ViewHolder(view)


        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition //不能放到setOnClickListener外面
            val desc = "您点击了第${position + 1}项，标题是${mInfos[position].title}"
            Toast.makeText(parent.context, desc, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnLongClickListener {
            val position = holder.adapterPosition
            val desc = "您长按了第${position + 1}项，标题是${mInfos[position].title}"
            Toast.makeText(parent.context, desc, Toast.LENGTH_SHORT).show()
            true
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mInfo = mInfos[position]
        holder.iv_pic.setImageResource(mInfo.pic_id)
        holder.tv_title.text = mInfo.title
        holder.tv_desc.text = mInfo.desc
    }

    override fun getItemCount(): Int = mInfos.size
}