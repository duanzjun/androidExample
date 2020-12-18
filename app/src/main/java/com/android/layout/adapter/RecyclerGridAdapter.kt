package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.R
import com.android.layout.bean.RecyclerInfo

class RecyclerGridAdapter(infos: MutableList<RecyclerInfo>) :
    RecyclerView.Adapter<RecyclerGridAdapter.ViewHolder>() {

    val mInfos = infos

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val iv_pic: ImageView = v.findViewById(R.id.iv_pic)
        val tv_title: TextView = v.findViewById(R.id.tv_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_grid, parent, false)

        val holder = ViewHolder(view)

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
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

    }

    override fun getItemCount(): Int = mInfos.size


}
