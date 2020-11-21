package com.example.base_bottom
/*
    交易物流
 */

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.base_bottom.wuliu_notice.Adapte_one
import com.example.base_bottom.wuliu_notice.MainActivity_notice
import kotlinx.android.synthetic.main.fragment_notifications.*

class BiscuitsFragment :Fragment(){

    private var listView: ListView? = null
    private var adapter: Adapte_one? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)

    }


    companion object {
        fun newInstance() : BiscuitsFragment {//调用这个函数，创建新的fragment

            val fragment = BiscuitsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        var mess: String? = null
        if (bundle != null) {
            Log.d("BiscuitsFragment",bundle.getString("account"))
            mess = bundle.getString("account")
        }

        scanBtn.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity_notice::class.java)
            intent.putExtra("account",mess)
            startActivity(intent)
        }
    }



}