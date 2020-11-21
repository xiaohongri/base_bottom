package com.example.base_bottom.wangjimima
/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.base_bottom.BaseActivity
import com.example.base_bottom.R
import kotlinx.android.synthetic.main.layout_activity_code.*

class youxiangzhaohui : BaseActivity() , View.OnClickListener  {

    private var mCurrentNum = 60
    private val TIME: Long = 1000

    fun contentView() {
        setContentView(R.layout.layout_activity_code)
        send_verify_code_layout.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send_verify_code_layout -> {
                edit_verifycode.postDelayed(this, TIME);
            }
        }
    }

    private val mRefreshRunnable: Runnable = object : Runnable {
        override fun run() {
            sendverifycode.text = mCurrentNum.toString() + “ s ”
            progressbar.visibility = View.GONE

            if (mCurrentNum == 0) {
                edit_verifycode.removeCallbacks(this)
                send_verify_code_layout.isEnabled = true
                sendverifycode.text = "重发验证码"
            } else {
                mCurrentNum -= 1
                edit_verifycode.postDelayed(this, TIME);
            }
            sendverifycode.visibility = View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youxiangzhaohui)
    }
}
'''
*/