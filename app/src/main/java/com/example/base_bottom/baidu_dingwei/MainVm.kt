package com.example.base_bottom.baidu_dingwei

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.baidu.mapapi.model.LatLng
import com.example.base_bottom.baidu_dingwei.base.MyViewModel
import com.example.base_bottom.baidu_dingwei.model.Bus
import com.example.base_bottom.baidu_dingwei.model.BusRoute
import com.example.base_bottom.baidu_dingwei.network.BusNetWork
import com.example.base_bottom.baidu_dingwei.util.logD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.math.abs

class MainVm: MyViewModel() {

    val points = MutableLiveData<ArrayList<LatLng>>()

    val busList = refreshLiveData.switchMap { liveData(viewModelScope.coroutineContext+ Dispatchers.IO) {
        val result = BusNetWork.getAllBus()
        emit(result)
    }}

    fun getRoute(id: String){
        viewModelScope.async(Dispatchers.IO) {
            val busRoute = BusNetWork.getBusRoute(id).position
            val pointList = arrayListOf<LatLng>()
            for (point in busRoute){
                pointList.add(LatLng(point.lat.toDouble(), point.lng.toDouble()))
            }
            points.postValue(pointList)
        }
    }

    fun isClickBus(lon: Double, lat: Double): Bus?{
        busList.value?.position?.let {
            for (bus in it){
                "lon = $lon bus.lon.toDouble() = ${bus.lng.toDouble()}".logD()
                "lat = $lat bus.lat.toDouble() = ${bus.lat.toDouble()}".logD()
                if (lon == bus.lng.toDouble() && lat == bus.lat.toDouble()){
                    return bus
                }
            }
        }
        return null
    }
}