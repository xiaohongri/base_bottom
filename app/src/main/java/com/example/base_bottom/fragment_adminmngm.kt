package com.example.base_bottom
/*
    报警信息界面--未开发
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class fragment_adminmngm : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_adminmngm, container, false)

    }


    companion object {
        fun newInstance() :fragment_adminmngm{//调用这个函数，创建新的fragment

            val fragment = fragment_adminmngm()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}
