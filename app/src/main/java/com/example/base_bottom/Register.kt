package com.example.base_bottom
/*
    注册页面--未开发
 */
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.base_bottom.mysql_act.sql_act
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.concurrent.thread

class Register : AppCompatActivity() {
    var account_rst = ""
    var password_rst = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        zhuce()
    }
    fun zhuce(){
        register_action.setOnClickListener {

            thread {
                account_rst = accountEdit_rst.text.toString()
                password_rst = passwordEdit_rst.text.toString()
                val phone_rst = phoneEdit_rst.text.toString()
                val mail_rst = mailEdit_rst.text.toString()
                val temp = sql_act()
                val temp_data = temp.updata("INSERT INTO customer_data (Account,Passwd,Telephone,Email) values (\""+account_rst+"\",\""+password_rst+"\",\""+phone_rst+"\",\""+mail_rst+"\")")
            }
            /*
            AlertDialog.Builder(this).apply {
                setTitle("提示信息")
                setMessage("账号已注册")
                setPositiveButton("确认"){dialog, which ->  }
                show()
            }

             */
            //Toast.makeText(this,"account or password is invalid", Toast.LENGTH_SHORT).show()
        }
    }
}
