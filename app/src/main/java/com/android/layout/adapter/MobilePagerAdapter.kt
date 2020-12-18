package com.android.layout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.layout.bean.GoodsInfo
import com.android.layout.fragment.MobileFragment

class MobilePagerAdapter(fa: FragmentActivity, val goodsList: List<GoodsInfo>) :
    FragmentStateAdapter(fa) {
    private val mGoodsList = goodsList

    override fun getItemCount(): Int = mGoodsList.size

    override fun createFragment(position: Int): Fragment {
        val goods = mGoodsList[position]
        return MobileFragment.newInstance(position, goods.pic, goods.desc)
    }

}