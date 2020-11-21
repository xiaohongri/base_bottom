package com.example.base_bottom
/*
    首页展示
 */
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import android.util.Log
import com.example.base_bottom.wuliu_notice.MainActivity_notice

import com.yzq.zxinglibrary.android.CaptureActivity
import com.yzq.zxinglibrary.common.Constant
import kotlinx.android.synthetic.main.fragment_home.*


class ArticleFragment: Fragment(){


    //private var view: View? = null


    //lateinit var timeChangeReceiver: PersonalFragment.TimeChangeReceiver
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        scanBtn_home?.setOnClickListener{


            val intent = Intent(getActivity(), CaptureActivity::class.java)
            Log.d(ContentValues.TAG,"111111111111111111")
            startActivityForResult(intent, 1111)
        }


        encodeBtnWithLogo1.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity_notice::class.java)
            Log.d(ContentValues.TAG,"111111111111111111")
            startActivityForResult(intent, 1111)
        }

    }

    private fun initView() {

        Log.d(ContentValues.TAG,"22222222222222222222222")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(ContentValues.TAG, requestCode.toString()+"1235555555555555555555")
        if (requestCode == 1111) {
            if (data != null) {

                val content = data.getStringExtra(Constant.CODED_CONTENT)
                Log.d(ContentValues.TAG,content+"1234567899999999999999999999999999999")
                //resultTv?.setText("扫描结果为：" + content)

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(content)
                startActivity(intent)

            }
        }


    }

    companion object {
        fun newInstance() : ArticleFragment {//调用这个函数，创建新的fragment

            val fragment = ArticleFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}