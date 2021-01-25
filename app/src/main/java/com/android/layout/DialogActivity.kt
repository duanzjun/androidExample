package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.layout.fragment.ListDialogFragment
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity(),
    ListDialogFragment.ConfirmCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)


        dialogTest1.setOnClickListener {
            val listDialogFragment = ListDialogFragment.newInstance("弹窗实例", "显示的内容")
            listDialogFragment.show(supportFragmentManager, "dialogFragment")
        }
    }

    override fun onConfirmSelect(res: Map<String, Any>?) {
        callMsg.text = res.toString()
    }
    
    companion object {
        const val TAG = "DialogActivity"
        fun actionStart(context: Context) {
            val intent = Intent(context, DialogActivity::class.java)
            context.startActivity(intent)
        }
    }


}