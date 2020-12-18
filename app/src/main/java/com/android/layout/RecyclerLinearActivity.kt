package com.android.layout

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.adapter.RecyclerLinearAdapter
import com.android.layout.bean.RecyclerInfo
import kotlinx.android.synthetic.main.activity_recycler_linear.*

class RecyclerLinearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_linear)

        rv_linear.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerLinearAdapter(RecyclerInfo.defaultList)

        rv_linear.adapter = adapter
        rv_linear.itemAnimator = DefaultItemAnimator()
        rv_linear.addItemDecoration(SpacesItemDecoration(1))
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, RecyclerLinearActivity::class.java)
            context.startActivity(intent)
        }
    }
}
//自定义上下左右间隔线
class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        outRect.top = space
    }
}
