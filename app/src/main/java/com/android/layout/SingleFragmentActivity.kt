package com.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun createFragment(): Fragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

//        获取FragmentManager
        val fragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
//            创建一个新的fragment事务，执行一个
//            fragment添加操作，然后提交该事务
            fragment = createFragment()
            if (fragment != null) {
                fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
            }
        }
    }
}