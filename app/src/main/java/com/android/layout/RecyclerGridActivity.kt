package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.android.layout.adapter.RecyclerGridAdapter
import com.android.layout.bean.RecyclerInfo
import kotlinx.android.synthetic.main.activity_recycler_grid.*

class RecyclerGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_grid)

        rv_grid.layoutManager = GridLayoutManager(this, 5)
        val adapter = RecyclerGridAdapter(RecyclerInfo.defaultGrid)

        rv_grid.adapter = adapter
        rv_grid.itemAnimator = DefaultItemAnimator()
        rv_grid.addItemDecoration(SpacesItemDecoration(1))
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, RecyclerGridActivity::class.java)
            context.startActivity(intent)

        }
    }
}