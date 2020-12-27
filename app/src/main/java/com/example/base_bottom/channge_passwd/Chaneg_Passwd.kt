package com.example.base_bottom.channge_passwd

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.base_bottom.R
import com.example.base_bottom.mysql_act.sql_act
import kotlinx.android.synthetic.main.activity_chaneg__passwd.*
import kotlin.concurrent.thread

class Chaneg_Passwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chaneg__passwd)
        button.setOnClickListener {
            var account = intent.getStringExtra("account")
            val now_account = now_pawwsd.text.toString()
            val next_password = next_passwd.text.toString()
            var temp_passwd = String()
//UPDATE cs_user SET gender = '男' WHERE id = 4
           thread {
                val temp = sql_act()
                val temp_data = temp.select("select Passwd from customer_data where Account = \""+account+"\"")  //
               while (temp_data?.next()!!) {
//                   println(temp_data.getString("Passwd"))
                   temp_passwd = temp_data.getString("Passwd")
               }
               if (now_account == temp_passwd){
                   val temp_change = temp.updata("UPDATE customer_data SET Passwd = \""+next_password+"\" WHERE Account =  \""+account+"\"")
                   AlertDialog.Builder(this).apply {
                       setTitle("提示信息")
                       setMessage("修改成功")
                       setPositiveButton("确认") { dialog, which -> }
                       show()
                   }
               }
               else{
                   AlertDialog.Builder(this).apply {
                       setTitle("提示信息")
                       setMessage("修改失败，请检查输入")
                       setPositiveButton("确认") { dialog, which -> }
                       show()
                   }
               }
            }
            Thread.sleep(1000)
        }
    }
}
