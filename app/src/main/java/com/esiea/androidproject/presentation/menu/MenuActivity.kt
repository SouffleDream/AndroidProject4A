package com.esiea.androidproject.presentation.menu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.esiea.androidproject.R
import com.esiea.androidproject.presentation.menu.first.FirstActivity
import com.esiea.androidproject.presentation.menu.fourth.CatActivity
import com.esiea.androidproject.presentation.menu.second.SecondActivity
import com.esiea.androidproject.presentation.menu.third.YoutubeActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        title = "Menu"

        val imageView = findViewById<ImageView>(R.id.imageView)
        val urlAPI = "http://placekitten.com/200/300"

        button_list_api.setOnClickListener(){
            startActivity(Intent(this, FirstActivity::class.java))
        }

        button_list_local.setOnClickListener(){
            startActivity(Intent(this, SecondActivity::class.java))
        }
        button_youtube_api.setOnClickListener(){
            startActivity(Intent(this, YoutubeActivity::class.java))
        }

        button_image_api.setOnClickListener(){
            startActivity(Intent(this, CatActivity::class.java))
        }
    }
}