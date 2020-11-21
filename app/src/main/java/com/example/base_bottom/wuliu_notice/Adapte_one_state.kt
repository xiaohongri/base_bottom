package com.example.base_bottom.wuliu_notice

import android.widget.TextView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.base_bottom.R


class Adapte_one_state(private val context: Context, private val list: List<Map<String, Any>>) :
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
                convertView = inflater!!.inflate(R.layout.item_state, null)
                viewHolder = TimeLineHolder()

                viewHolder.title = convertView!!.findViewById(R.id.title_state)
                viewHolder.time = convertView!!.findViewById(R.id.tv_time)
                viewHolder.time_state = convertView!!.findViewById(R.id.time_state)
                convertView!!.setTag(viewHolder)
            } else {
                viewHolder = convertView!!.getTag() as TimeLineHolder?
            }

            val titleStr = list[position]["title"]!!.toString()

            val timeStr = list[position]["time"]!!.toString()

            val stateStr = list[position]["time_state"]!!.toString()



            if (viewHolder != null) {
                viewHolder.title?.setText(titleStr)
                viewHolder.time?.setText(timeStr)
                viewHolder.time_state?.setText(stateStr)
            }

            return convertView

        }

        internal class TimeLineHolder {
            var title: TextView? = null
            var time: TextView? = null
            var time_state: TextView? = null
        }

}