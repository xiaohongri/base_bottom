package com.example.base_bottom.baidu_dingwei.network

import com.example.base_bottom.baidu_dingwei.model.AllBus
import com.example.base_bottom.baidu_dingwei.model.BusRoute
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetBusData {
    //
    @GET("/home/home/getdata")
    fun getAllBus(): Call<AllBus>

    @GET("/home/home/getroute/{busId}")
    fun getBusRoute(@Path("busId")busId: String): Call<BusRoute>
}