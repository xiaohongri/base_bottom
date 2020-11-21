package com.example.base_bottom
/*
    忘记密码--未开发
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.base_bottom.wangjimima.shoujizhaohui
//import com.example.base_bottom.wangjimima.youxiangzhaohui
import kotlinx.android.synthetic.main.activity_forgetpw.*

class Forgetpw : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpw)

        shouji_btn.setOnClickListener {
            val intent = Intent(this,shoujizhaohui::class.java)
            startActivity(intent)
        }
/*
        email_btn.setOnClickListener {
            val intent = Intent(this,youxiangzhaohui::class.java)
            startActivity(intent)
        }

 */
    }
}
