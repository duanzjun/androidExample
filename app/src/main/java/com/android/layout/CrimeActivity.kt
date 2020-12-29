package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.android.layout.bean.Crime
import kotlinx.android.synthetic.main.activity_crime.*
import java.util.*


class CrimeActivity : SingleFragmentActivity(), CrimeListFragment.Callbacks {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)
    }

    //
    override fun createFragment(): Fragment? {
        return CrimeListFragment()
    }

    override fun onCrimeSelected(crimeId: UUID){

        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//        Crime.defaultList[crimeId].title = etTitle.text.toString()
//        Log.d("CrimeActivity#onBackPressed", etTitle.text.toString())
//
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//        Log.d("CrimeActivity", etTitle.text.toString())
//    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, CrimeActivity::class.java).apply {
//                putExtra("id", crimeId)
            }
            context.startActivity(intent)
        }
    }


}