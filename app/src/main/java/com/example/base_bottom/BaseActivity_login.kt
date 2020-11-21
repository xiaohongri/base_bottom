package com.example.base_bottom
/*
    个人中心页面返回登陆按钮操作
 */
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity_login : AppCompatActivity() {

    lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }


    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }


    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("提示：")
                setMessage("返回登陆界面")
                setCancelable(false)
                setPositiveButton("确认") { _, _ ->
                    ActivityCollector.finishAll()
                    val i = Intent(context, LOGINActivity::class.java)
                    context.startActivity(i)
                }
                show()
            }
        }
    }
}
