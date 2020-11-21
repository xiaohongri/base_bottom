package com.example.base_bottom.baidu_dingwei.network

import com.example.base_bottom.baidu_dingwei.base.MyApplication
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCreator {
    fun<T> create(serviceClass: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(MyApplication.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
            .build()
        return retrofit.create(serviceClass)
    }
}