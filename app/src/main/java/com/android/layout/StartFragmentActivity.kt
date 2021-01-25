package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.layout.fragment.StartFragment

class StartFragmentActivity : AppCompatActivity() {

    var num: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_fragment)

        addFragment(StartFragment.newInstance(num, "A"))
    }


    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.frg, fragment)
            add(R.id.frg, fragment)
            commit()
        }
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
//            replace(R.id.frg, fragment)
//            addToBackStack(null)
            add(R.id.frg, fragment, "frist")
            commit()
        }
    }


    override fun onBackPressed() {
//        管理fragment回退栈
//        super.onBackPressed()
//        Toast.makeText(MainActivity.this, "left count:"+getSupportFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
        Toast.makeText(
            this,
            "left  count:" + supportFragmentManager.backStackEntryCount,
            Toast.LENGTH_SHORT
        ).show()
//        if(getSupportFragmentManager().getBackStackEntryCount() <= 0)//这里是取出我们返回栈存在Fragment的个数
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, StartFragmentActivity::class.java)
            context.startActivity(intent)
        }
    }
}