package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.android.layout.adapter.MobilePagerAdapter
import com.android.layout.bean.GoodsInfo
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_pager2)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_h -> {
                    vp2_content.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }
                R.id.rb_v -> {
                    vp2_content.orientation = ViewPager2.ORIENTATION_VERTICAL
                }
            }
        }

//        设置翻页视图的排列方式为水平方向
        rb_h.isChecked = true
//        构建一个商品信息列表的循环适配器
//        val adapter = MobileRecyclerAdapter(GoodsInfo.defaultList)
//        构建一个商品信息的翻页适配器
        val adapter = MobilePagerAdapter(this, GoodsInfo.defaultList)
        vp2_content.adapter = adapter
//        翻页过程动画，翻页时内容旋转360度
        val animator =
            ViewPager2.PageTransformer { page: View, position: Float ->
                page.rotation = position * 360
            }
        vp2_content.setPageTransformer(animator)
//        把标签布局跟翻页视图通过指定策略连为一体，在页面切换时联动
        TabLayoutMediator(tab_title, vp2_content) { tab, position ->
            tab.text = GoodsInfo.defaultList[position].name
        }.attach()
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, ViewPager2Activity::class.java)
            context.startActivity(intent)
        }
    }
}