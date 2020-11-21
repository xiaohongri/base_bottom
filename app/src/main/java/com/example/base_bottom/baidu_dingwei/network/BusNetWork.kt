package com.example.base_bottom.baidu_dingwei.network

import retrofit2.await

object BusNetWork {
    private val service = RetrofitCreator.create(GetBusData::class.java)
    suspend fun getAllBus()= service.getAllBus().await()
    suspend fun getBusRoute(busId: String)= service.getBusRoute(busId).await()
}