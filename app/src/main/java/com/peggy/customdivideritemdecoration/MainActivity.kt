package com.peggy.customdivideritemdecoration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //這裡有一個版面問題，當有問題時去改變recycler_view.xml的layout_height改成wrap_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        fun getInfoList(): MutableList<Info> {
            val datas = mutableListOf<Info>(
                Info("標題一", "123456789"),
                Info("標題二", "987654321"),
                Info("標題三", "987654321"),
                Info("標題四", "123456789")
            )
            return datas
        }

         /*自行定義樣式(shape -> 顏色跟高度)與尺寸(整個手機版面) */
        val dividerItemDecoration = CustomDividerItemDecoration(resources.getDrawable(R.drawable.shape_line),resources.getDimensionPixelOffset(R.dimen.margin_30))
        recyclerView.addItemDecoration(dividerItemDecoration)

        val myadapter = MainAdapter(this,getInfoList())
        recyclerView.adapter = myadapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}