package com.example.base_bottom.wuliu_merchant

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.base_bottom.R
import kotlinx.android.synthetic.main.activity_pinlunqu.*

class pinlunqu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinlunqu)

        punlun_btn.setOnClickListener {





            AlertDialog.Builder(this).apply {
                setTitle("提示")
                setMessage("非常感谢您宝贵的建议")
                setPositiveButton("确认") { dialog, which -> }
                show()
            }
        }
    }


}
