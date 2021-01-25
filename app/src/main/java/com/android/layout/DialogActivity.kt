package com.android.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

//        最普通的弹窗
        dialogTest2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val alert = builder.setTitle("系统提示")
                .setMessage("这是一个最普通的AlertDialog,,带有三个按钮，分别是取消、确定、中立")
                .setNegativeButton("取消") { _, _ ->
                    Toast.makeText(this, "你点击了取消按钮~", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("确定") { _, _ ->
                    Toast.makeText(this, "你点击了确定按钮~", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("中立") { _, _ ->
                    Toast.makeText(this, "你点击了中立按钮~", Toast.LENGTH_SHORT).show()
                }
                .create()
            alert.show()
        }

//       列表
        dialogTest3.setOnClickListener {
            val lesson =
                arrayOf("语文", "数学", "英语", "化学", "生物", "物理", "体育", "游戏", "政治", "考研", "文艺", "画画")
            val builder = AlertDialog.Builder(this)
            val alert = builder.setTitle("选择您喜欢的课程")
            builder.setItems(lesson) { _, which ->
                Toast.makeText(this, "您选择的是${lesson[which]}", Toast.LENGTH_SHORT).show()
            }.create()
            alert.show()
        }

//        单选框
        dialogTest4.setOnClickListener {
            val fruits = arrayOf("苹果", "雪梨", "香蕉", "葡萄", "西瓜")
            val builder = AlertDialog.Builder(this)
            val alert = builder.setTitle("选择您喜欢的水果，只能选择一个哦~")
                .setSingleChoiceItems(fruits, 0) { _, which ->
                    Toast.makeText(this, "你选择了${fruits[which]}", Toast.LENGTH_SHORT).show()
                }
                .create()
            alert.show()

        }

        dialogTest5.setOnClickListener {
            val menu = arrayOf("水煮豆腐", "萝卜牛腩", "酱油鸡", "胡椒猪肚鸡")
//               定义一个用来记录列表项状态的boolean数组
            val checkItems = booleanArrayOf(false, true, false, false)
            var builder = AlertDialog.Builder(this)
            var alert = builder
                .setMultiChoiceItems(
                    menu, checkItems
                ) { _, which, isChecked ->
                    checkItems[which] = isChecked
                }
                .setPositiveButton("确定") { _, _ ->
                    var result = ""
                    for (i in checkItems.indices) {
                        if (checkItems[i]) result += menu[i] + ""
                    }
                    Toast.makeText(this, "客官你点了:$result", Toast.LENGTH_SHORT).show()
                }
                .create()
            alert.show()
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