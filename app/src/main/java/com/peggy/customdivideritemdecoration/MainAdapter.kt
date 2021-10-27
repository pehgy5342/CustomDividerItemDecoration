package com.peggy.customdivideritemdecoration

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(context: Context, var infoList: List<Info>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {



    //建立每一個項目，這邊需要把recycler_view.xml中的項目找出來並回傳
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    //將資訊放入項目
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(infoList[position])
    }

    //獲得清單項的數目，= this.infos.count()代表的意思是獲取Info.kt中所有項目
    override fun getItemCount(): Int = infoList.count()


    //用來裝入recycler_view.xml中所有需要被置入值的view，目的是不用每次建立一個項目時多一個view，而是讓他們可回收再利用
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val infotitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val infocontent = itemView.findViewById<TextView>(R.id.tv_info)

        //把資料變成可視的 view 的過程
        fun bind(info: Info) {
            infotitle.text = info.infotitle
            infocontent.text = info.infocontent

        }

    }
}
