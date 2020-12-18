package com.android.layout

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import com.android.layout.adapter.PlanetGridAdapter
import com.android.layout.bean.Planet
import kotlinx.android.synthetic.main.activity_grid_view.*

class GridViewActivity : AppCompatActivity() {
    private val dividers = listOf<String>(
        "不显示分隔线",
        "只显示内部分隔线(NO_STRETCH)",
        "只显示内部分隔线(COLUMN_WIDTH)",
        "只显示内部分隔线(STRETCH_SPACING)",
        "只显示内部分隔线(SPACING_UNIFORM)",
        "显示全部分隔线(看我用padding大法)",
    )

    private val dividerPad = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        val adapter = PlanetGridAdapter(this, Planet.defaultList, Color.WHITE)
        gv_planet.adapter = adapter

        initSpinner()
    }

    private fun initSpinner() {
        val startAdapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, dividers)

        sp_grid.prompt = "请选择分割线显示方式"
        sp_grid.adapter = startAdapter

        sp_grid.onItemSelectedListener = MySelectedListener()
    }

    internal inner class MySelectedListener : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            gv_planet.setBackgroundColor(Color.RED)
            gv_planet.horizontalSpacing = dividerPad
            gv_planet.verticalSpacing = dividerPad
            gv_planet.stretchMode = GridView.STRETCH_COLUMN_WIDTH
            gv_planet.columnWidth = 250
            gv_planet.setPadding(0, 0, 0, 0)
            when (position) {
                0 -> {
                    gv_planet.setBackgroundColor(Color.WHITE)
                    gv_planet.horizontalSpacing = 0
                    gv_planet.verticalSpacing = 0
                }
                1 -> gv_planet.stretchMode = GridView.NO_STRETCH
                2 -> gv_planet.stretchMode = GridView.STRETCH_COLUMN_WIDTH
                3 -> gv_planet.stretchMode = GridView.STRETCH_SPACING
                4 -> gv_planet.stretchMode = GridView.STRETCH_SPACING_UNIFORM
                5 -> gv_planet.setPadding(dividerPad, dividerPad, dividerPad, dividerPad)
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }


    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, GridViewActivity::class.java)
            context.startActivity(intent)

        }
    }

}