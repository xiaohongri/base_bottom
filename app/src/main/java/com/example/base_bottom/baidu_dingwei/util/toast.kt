package com.example.base_bottom.baidu_dingwei.util

import android.widget.Toast
import com.example.base_bottom.baidu_dingwei.base.MyApplication

fun String.toast(){
    Toast.makeText(MyApplication.context, this, Toast.LENGTH_SHORT).show()
}

fun String.logD(){
    LogUtil.logD(this)
}
fun String.logD(tag: String){
    LogUtil.logD(tag,this)
}

fun String.logE(tag: String){
    LogUtil.logE(tag,this)
}