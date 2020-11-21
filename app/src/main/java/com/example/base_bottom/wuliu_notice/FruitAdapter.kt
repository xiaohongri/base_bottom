package com.example.base_bottom.wuliu_notice

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.base_bottom.R

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Wuliu>) : ArrayAdapter<Wuliu>(activity, resourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.wuliu_image)
            val fruitName: TextView = view.findViewById(R.id.title)
            val wuliu_data: TextView = view.findViewById(R.id.time)
            viewHolder = ViewHolder(fruitImage, fruitName, wuliu_data)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position) // 获取当前项的Fruit实例
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.state
            viewHolder.wuliu_data.text = fruit.data
        }
        return view
    }

    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView,val wuliu_data: TextView)

}