package com.example.base_bottom.wuliu_notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.base_bottom.R
import com.example.base_bottom.mysql_act.sql_act
import kotlinx.android.synthetic.main.activity_main_wuliu.*
import kotlin.concurrent.thread

class MainActivity_notice : AppCompatActivity() {

    private val fruitList = ArrayList<Wuliu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_wuliu)
        var account = intent.getStringExtra("account")
        initFruits(account) // 初始化数据

        val adapter = FruitAdapter(this, R.layout.item, fruitList)
        lv_list.adapter = adapter
       // lv_list.setOnItemClickListener { parent, view, position, id ->

        //}
        lv_list.setOnItemClickListener { _, _, position, _ ->
            val fruit = fruitList[position]
            val data = fruit.data
            val intent = Intent(this, MainActivity_state::class.java)
            intent.putExtra("Item_id",fruit.Item_id)
            startActivity(intent)
            Toast.makeText(this, fruit.state, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits(account: String?) {

        thread {
            val temp = sql_act()
            val temp_data = temp.select("select* from logistics_information where Account = \""+account+"\"")  //
            //println(temp_data)
            while (temp_data?.next()!!) {
                //println(temp_data.getString(1))
                fruitList.add(Wuliu(temp_data.getString("Item"), R.drawable.apple_pic,temp_data.getString("Cur_date"),temp_data.getString("Item_id")))
            }
        }
        Thread.sleep(1000)

        repeat(1) {
            fruitList.add(Wuliu("Apple", R.drawable.apple_pic,"1","1"))
            fruitList.add(Wuliu("Banana", R.drawable.banana_pic,"2","1"))
            fruitList.add(Wuliu("Orange", R.drawable.orange_pic,"3","1"))
            fruitList.add(Wuliu("Watermelon", R.drawable.watermelon_pic,"4","1"))
            fruitList.add(Wuliu("Pear", R.drawable.pear_pic,"5","1"))
            fruitList.add(Wuliu("Grape", R.drawable.grape_pic,"6","1"))
            fruitList.add(Wuliu("Pineapple", R.drawable.pineapple_pic,"7","1"))
            fruitList.add(Wuliu("Strawberry", R.drawable.strawberry_pic,"8","1"))
            fruitList.add(Wuliu("Cherry", R.drawable.cherry_pic,"9","1"))
            fruitList.add(Wuliu("Mango", R.drawable.mango_pic,"10","1"))
        }


    }

}