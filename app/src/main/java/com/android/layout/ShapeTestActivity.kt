package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ShapeTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_test)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, ShapeTestActivity::class.java)
            context.startActivity(intent)
        }
    }
}