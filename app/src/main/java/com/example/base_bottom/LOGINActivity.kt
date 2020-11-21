package com.example.base_bottom

/*


    登陆界面
 */
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.example.base_bottom.get_msg_from_msq.login_get
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.concurrent.thread


class LOGINActivity : BaseActivity_login() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password",false)
        if (isRemember){
            val account = prefs.getString("account","")
            val password = prefs.getString("password","")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }

        login.setOnClickListener{

            thread {
                val account = accountEdit.text.toString()
                val password = passwordEdit.text.toString()

                val login_temp = login_get()
                val login_key = login_temp.Login(getname = account, pwd = password)


                if(login_key == "{\"ifok\":\"true\"}"){

                    val editor = prefs.edit()
                    if (rememberPass.isChecked){
                        editor.putBoolean("remember_password",true)
                        editor.putString("account",account)
                        editor.putString("password",password)

                    }else{
                        editor.clear()
                    }
                    editor.apply()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("account",account)
                    startActivity(intent)
                    finish()
                }else{
                    //Toast.makeText(this,"account or password is invalid",Toast.LENGTH_SHORT).show()
                }
            }





        }
        register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        forgetpw.setOnClickListener {
            val intent = Intent(this, Forgetpw::class.java)
            startActivity(intent)
        }


    }
}
