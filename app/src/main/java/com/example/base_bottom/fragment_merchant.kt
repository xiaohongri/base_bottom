package com.example.base_bottom
/*
    商家区--未开发
 */
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.base_bottom.wuliu_merchant.pinlunqu
import kotlinx.android.synthetic.main.activity_fragment_merchant.*


class fragment_merchant : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_merchant, container, false)

    }


    companion object {
        fun newInstance() :fragment_merchant{//调用这个函数，创建新的fragment

            val fragment = fragment_merchant()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mercBtn2.setOnClickListener {
            val intent = Intent(activity, pinlunqu::class.java)
            startActivity(intent)
        }
    }
}
