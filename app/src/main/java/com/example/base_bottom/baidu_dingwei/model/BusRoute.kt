package com.example.base_bottom.baidu_dingwei.model

data class BusRoute(
    var status: Int,
    var position: List<Route>
)

data class Route(
    var lng: String,
    var lat: String,
    var cur_date: Long
)