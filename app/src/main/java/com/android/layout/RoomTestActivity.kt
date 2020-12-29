package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.layout.bean.AppDatabase
import com.android.layout.bean.User
import kotlinx.android.synthetic.main.activity_room_test.*
import kotlin.concurrent.thread

class RoomTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }

        }

        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 43
                userDao.updateUser(user1)
            }
        }

        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }

        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("RoomTestActivity", user.toString())
                }
            }
        }


    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, RoomTestActivity::class.java)
            context.startActivity(intent)
        }
    }
}