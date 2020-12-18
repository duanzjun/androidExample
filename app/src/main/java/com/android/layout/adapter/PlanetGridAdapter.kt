package com.android.layout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.layout.R
import com.android.layout.bean.Planet


class PlanetGridAdapter(
    private val context: Context,
    private val planetList: MutableList<Planet>,
    private val background: Int
) :
    BaseAdapter(), AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    val mPlanetList = planetList

    override fun getCount(): Int = mPlanetList.size

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder
        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_grid_view, null)
            holder = ViewHolder(view)
            //视图持有者的内部控件对象已经在构造时一并初始化了，故这里无需再做赋值
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val mPlanet = mPlanetList[position]

        holder.ll_item.setBackgroundColor(background)
        holder.iv_icon.setImageResource(mPlanet.image)
        holder.tv_name.text = mPlanet.name
        holder.tv_desc.text = mPlanet.desc

        return view!!
    }


    inner class ViewHolder(val view: View) {
        val ll_item = view.findViewById<LinearLayout>(R.id.ll_item)
        val iv_icon = view.findViewById<ImageView>(R.id.iv_icon)
        val tv_name = view.findViewById<TextView>(R.id.tv_name)
        val tv_desc = view.findViewById<TextView>(R.id.tv_desc)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val desc = "您点击了第${position + 1}个行星，它的名字是${mPlanetList[position].name}"
        Toast.makeText(context, desc, Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ): Boolean {
        val desc = "您长按了第${position + 1}个行星，它的名字是${mPlanetList[position].name}"
        Toast.makeText(context, desc, Toast.LENGTH_SHORT).show()
        return true
    }


}
