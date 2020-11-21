package com.example.base_bottom.wuliu_notice


import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.ListView
import com.example.base_bottom.R
import com.example.base_bottom.baidu_dingwei.MainActivity_ditu
import com.example.base_bottom.mysql_act.sql_act
import kotlinx.android.synthetic.main.activity_main_state.*
import kotlin.concurrent.thread


class MainActivity_state : Activity() {

    private var listView: ListView? = null
    private var adapter: Adapte_one_state? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_state)
        listView = findViewById(R.id.lv_list_state) as ListView
        listView!!.setDividerHeight(0)
        adapter = Adapte_one_state(this, initData())
        listView!!.setAdapter(adapter)
        view_ditu.setOnClickListener {
            val intent = Intent(this,MainActivity_ditu::class.java)
            startActivity(intent)
        }
    }

    private fun initData(): List<Map<String, Any>> {
        val list = ArrayList<Map<String, Any>>()
        var Item_id = intent.getStringExtra("Item_id")
        thread {
            val temp = sql_act()
            val temp_data = temp.select("select* from logistics_information where Item_id = \""+Item_id+"\"")  //
            //println(temp_data)
            while (temp_data?.next()!!) {
                println(temp_data.getString(1))
                var map: MutableMap<String, Any> = HashMap()
                map["title"] = temp_data.getString("State")
                map["time"] = temp_data.getString("Cur_date")
                map["time_state"] = temp_data.getString("Cur_position")
                list.add(map)
                //fruitList.add(Wuliu(temp_data.getString(2), R.drawable.apple_pic,temp_data.getString(6)))
            }
        }
        Thread.sleep(1000)

/*
        var map: MutableMap<String, Any> = HashMap()
        map["title"] = "提交已完成......"
        map["time"] = "2015-10-22  14:00:00"
        map["time_state"] = "2015-10-22  16:00:00"
        list.add(map)

        map = HashMap()
        map["title"] = "正在审核中......"
        map["time"] = "2015-10-22  15:00:00"
        map["time_state"] = "2015-10-22  16:00:00"
        list.add(map)

        map = HashMap()
        map["title"] = "客服将会给您打电话......"
        map["time"] = "2015-10-22  16:00:00"
        map["time_state"] = "2015-10-22  16:00:00"
        list.add(map)

        map = HashMap()
        map["title"] = "反反复复烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦反反复复烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦"
        map["time"] = "2015-10-22  17:00:00"
        map["time_state"] = "2015-10-22  16:00:00"
        list.add(map)

 */

        return list

    }


}