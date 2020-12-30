package com.esiea.androidproject.presentation.menu.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.esiea.androidproject.R
import com.esiea.androidproject.data.local.models.AndroidModel

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "List Version Android"
        val listView = findViewById<ListView>(R.id.main_ListView)
        val list = ArrayList<AndroidModel>()

        list.add(AndroidModel("Android Donut 1.6", "Released in September 2009", R.drawable.donut)) //1
        list.add(AndroidModel("Android Eclair 2.0", "Released in October 2009", R.drawable.eclair)) //2
        list.add(AndroidModel("Android Froyo 2.2", "Released in May 2010", R.drawable.froyo)) //3
        list.add(AndroidModel("Android Honeycomb 3.0", "Released in Febuary 2011", R.drawable.honeycomb)) //4
        list.add(AndroidModel("Android IceCream Sandwich 4.0", "Released in October 2011", R.drawable.icecream)) //4
        list.add(AndroidModel("Android Jelly Bean 4.1", "Released in July 2012", R.drawable.jellybean)) //5
        list.add(AndroidModel("Android Kitkat 4.4", "Released in October 2013", R.drawable.kitkat)) //6
        list.add(AndroidModel("Android Lollipop 5.0", "Released in November 2014", R.drawable.lollipop)) //7
        list.add(AndroidModel("Android Marshmallow 6.0", "Released in May 2015", R.drawable.marshmallow)) //8
        list.add(AndroidModel("Android Nougat 7.0", "Released in March 2016", R.drawable.nougat)) //9
        list.add(AndroidModel("Android Oreo 8.0", "Released in August 2017", R.drawable.oreo)) //10
        list.add(AndroidModel("Android Pie 9.0", "Released in March 2018", R.drawable.pie)) //11

        val myListAdapter = SecondAdapterList(this, R.layout.android_row_list, list)
        listView.adapter = myListAdapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val itemIsAtThisPosition = list[position].version
                Toast.makeText(this, "$itemIsAtThisPosition", Toast.LENGTH_LONG).show()
        }
    }
}