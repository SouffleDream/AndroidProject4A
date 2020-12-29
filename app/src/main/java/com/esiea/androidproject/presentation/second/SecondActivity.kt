package com.esiea.androidproject.presentation.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.esiea.androidproject.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val listView = findViewById<ListView>(R.id.main_ListView)
        val list = ArrayList<Model>()

        list.add(Model("Android Donut 1.6","Released in September 2009", R.drawable.donut)) //1
        list.add(Model("Android Eclair 2.0","Released in October 2009", R.drawable.eclair)) //2
        list.add(Model("Android Froyo 2.2","Released in May 2010", R.drawable.froyo)) //3
        list.add(Model("Android Honeycomb 3.0","Released in Febuary 2011", R.drawable.honeycomb)) //4
        list.add(Model("Android IceCream Sandwich 4.0","Released in October 2011", R.drawable.icecream)) //4
        list.add(Model("Android Jelly Bean 4.1","Released in July 2012", R.drawable.jellybean)) //5
        list.add(Model("Android Kitkat 4.4","Released in October 2013", R.drawable.kitkat)) //6
        list.add(Model("Android Lollipop 5.0","Released in November 2014", R.drawable.lollipop)) //7
        list.add(Model("Android Marshmallow 6.0","Released in May 2015", R.drawable.marshmallow)) //8
        list.add(Model("Android Nougat 7.0","Released in March 2016", R.drawable.nougat)) //9
        list.add(Model("Android Oreo 8.0","Released in August 2017", R.drawable.oreo)) //10
        list.add(Model("Android Pie 9.0","Released in March 2018", R.drawable.pie)) //11

        val myListAdapter = AdapterList(this, R.layout.row_list, list)
        listView.adapter = myListAdapter

            listView.setOnItemClickListener { adapterView, _, position, _ ->
                val itemAtPosition = adapterView.getItemAtPosition(position)
                Toast.makeText(this, "$itemAtPosition", Toast.LENGTH_LONG).show()
        }
    }
}