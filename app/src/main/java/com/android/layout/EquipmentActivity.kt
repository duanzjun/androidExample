package com.android.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.layout.adapter.CommonAdapter
import com.android.layout.bean.CommonItemModel
import com.android.layout.bean.CommonModel
import kotlinx.android.synthetic.main.activity_equipment.*

class EquipmentActivity : AppCompatActivity() {

    private val mCommonList: MutableList<CommonItemModel> = ArrayList() //标题头
    private val mCommonList1: MutableList<CommonItemModel> = ArrayList() //内容列表
    private val mList: MutableList<CommonModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)

        val item = CommonItemModel("我的关注", "")
        mCommonList.add(item)
        val item1 = CommonItemModel("全民抽1", "")
        mCommonList1.add(item1)
        val item2 = CommonItemModel("全民抽奖2", "")
        mCommonList1.add(item2)
        val item3 = CommonItemModel("全民抽奖3", "")
        mCommonList1.add(item3)
        val item4 = CommonItemModel("全民抽奖4", "")
        mCommonList1.add(item4)
        val item5 = CommonItemModel("全民抽奖5", "")
        mCommonList1.add(item5)
        val item6 = CommonItemModel("全民抽奖6", "")
        mCommonList1.add(item6)

        val commModel = CommonModel("常用", mCommonList)
        val commModel1 = CommonModel("发现", mCommonList1)
        mList.add(commModel)
        mList.add(commModel1)

        //引入适配器
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = CommonAdapter(mList)
        recyclerView.adapter = adapter
    }
}