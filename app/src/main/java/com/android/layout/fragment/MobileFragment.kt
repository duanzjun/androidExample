package com.android.layout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.layout.R

class MobileFragment : Fragment() {
    private var mPosition: Int = 0
    private var mImageId: Int = 0
    private var mDesc: String? = null
    private var mPrice: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (arguments != null) {
            mPosition = requireArguments().getInt("position", 0)
            mImageId = requireArguments().getInt("image_id", 0)
            mDesc = requireArguments().getString("desc")
        }
        val view = inflater.inflate(R.layout.item_mobile, container, false)
        val iv_pic: ImageView = view.findViewById(R.id.iv_pic)
        val tv_desc: TextView = view.findViewById(R.id.tv_desc)
        iv_pic.setImageResource(mImageId)
        tv_desc.text = "$mDesc\n售价：$mPrice"
        return view
    }

    companion object {
        fun newInstance(position: Int, image_id: Int, desc: String): MobileFragment {
            val fragment = MobileFragment()
            val bundle = Bundle()
            bundle.putInt("position", position)
            bundle.putInt("image_id", image_id)
            bundle.putString("desc", desc)
            fragment.arguments = bundle
            return fragment
        }
    }
}
