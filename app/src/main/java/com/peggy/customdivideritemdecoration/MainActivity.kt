package com.peggy.customdivideritemdecoration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //這裡有一個版面問題，當有問題時去改變recycler_view.xml的layout_height改成wrap_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun getInfoList(): MutableList<Info> {
            val datas = mutableListOf<Info>(

                Info("標題一", "123456789"),
                Info("標題二", "987654321"),
                Info("標題三", "987654321"),
                Info("標題四", "123456789")


            )
            return datas
        }



        val dividerItemDecoration = CustomDividerItemDecoration(resources.getDrawable(R.drawable.shape_line),60)
        /**
         * 第二种分割线 自定义 divider_bg
         */
        //  dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.shape_line))

        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.addItemDecoration(dividerItemDecoration)

        val myadapter = MainAdapter(this,getInfoList())
        recyclerView.adapter = myadapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}