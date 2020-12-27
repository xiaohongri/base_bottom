package com.example.base_bottom.baidu_dingwei.model

data class AllBus(
    var status: Int,
    var position: List<Bus>?
)

data class Bus(
    var item_id: String,
    var lng: String,
    var lat: String,
    var state: String,
    //var numberOfPeople: Int,
    //var loadNumberOfPeople: Int,
    //var numberOfPeopleMasks: Int,
    //var smoking: Int,
    var pos: String,
    //var state2: String,
    var cur_date: Long
)


