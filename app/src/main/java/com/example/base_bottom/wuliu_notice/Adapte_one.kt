package com.example.base_bottom.wuliu_notice


import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.base_bottom.BiscuitsFragment
import com.example.base_bottom.R


class Adapte_one(private val context: BiscuitsFragment, private val list: List<Map<String, Any>>) :
    BaseAdapter() {
    private var inflater: LayoutInflater? = null

    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return list.size
    }

    override fun getItem(position: Int): Any {
        // TODO Auto-generated method stub
        return position
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // TODO Auto-generated method stub
        var viewHolder: TimeLineHolder? = null
        if (convertView == null) {
            inflater = LayoutInflater.from(parent.context)
            convertView = inflater!!.inflate(R.layout.item, null)
            viewHolder = TimeLineHolder()

            viewHolder.title = convertView!!.findViewById(com.example.base_bottom.R.id.title)
            viewHolder.time = convertView!!.findViewById(com.example.base_bottom.R.id.time)
            convertView!!.setTag(viewHolder)
        } else {
            viewHolder = convertView!!.getTag() as TimeLineHolder?
        }

        val titleStr = list[position]["title"]!!.toString()

        val timeStr = list[position]["time"]!!.toString()



        if (viewHolder != null) {
            viewHolder.title?.setText(titleStr)
            viewHolder.time?.setText(timeStr)
        }

        return convertView

    }

    internal class TimeLineHolder {
        var title: TextView? = null
        var time: TextView? = null
    }

}