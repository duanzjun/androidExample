package com.android.layout.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.android.layout.R
import kotlinx.android.synthetic.main.fragment_dialog_list.*

class ListDialogFragment : DialogFragment() {

    private var mMapParam: Map<String, Any>? = null
    private var mTitle: String? = null
    private var mMessage: String? = null
//    传递返回值
    private var mCallbacks: ConfirmCallbacks? = null


    interface ConfirmCallbacks {
        fun onConfirmSelect(map_param: Map<String, Any>?)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (arguments != null) {
            mTitle = requireArguments().getString("title", "")
            mMessage = requireArguments().getString("message", "")
        }

        val view = inflater.inflate(R.layout.fragment_dialog_list, container, false)

        view.findViewById<TextView>(R.id.dTitle).text = mTitle
        view.findViewById<TextView>(R.id.dMessage).text = mMessage

        //没有这个赋值无法获取返回值
        mCallbacks = activity as ConfirmCallbacks

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        执行动作内容
        btnSubmit.setOnClickListener {
//            dialogClickListener?.onDialogPositiveClickListener(view, "确定")
////            返回的内容
            mMapParam = mapOf("cancel" to "确定", "one" to "过期", "two" to 2, "three" to 3)
            mCallbacks?.onConfirmSelect(mMapParam)
            dismiss()
        }

        btnCancel.setOnClickListener {
            mMapParam = mapOf("cancel" to "取消", "one" to 1, "two" to 2, "three" to 3)
            mCallbacks?.onConfirmSelect(mMapParam)
            dismiss()
        }

        dClose.setOnClickListener {
            dismiss()
        }
    }


    companion object {
        const val TAG = "ListDialogFragment"

        fun newInstance(title: String, message: String): ListDialogFragment {
            val fragment = ListDialogFragment()
            val bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("message", message)
            fragment.arguments = bundle
            return fragment
        }
    }
}