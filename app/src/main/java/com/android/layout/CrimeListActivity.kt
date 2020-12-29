package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.layout.adapter.CrimeAdapter
import com.android.layout.bean.Crime
import kotlinx.android.synthetic.main.activity_crime_list.*
import java.util.*

class CrimeListActivity : SingleFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_list)

    }

    override fun createFragment(): Fragment? {
        return CrimeListFragment()
    }


    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, CrimeListActivity::class.java)
            context.startActivity(intent)
        }
    }
}