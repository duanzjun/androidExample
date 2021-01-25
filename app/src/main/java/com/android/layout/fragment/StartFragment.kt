package com.android.layout.fragment

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.layout.R
import com.android.layout.StartFragmentActivity
import kotlinx.android.synthetic.main.fragment_start.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StartFragment : Fragment() {
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        title.text = "StartFragment" + param1.toString()
        btnStart.setOnClickListener {
            val num = param1 ?: 0
//            SecondFragment.newInstance(num + 1, param2 ?: "")
            val startFragmentActivity = activity as StartFragmentActivity
            startFragmentActivity.replaceFragment(SecondFragment.newInstance(num, "B"))
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}