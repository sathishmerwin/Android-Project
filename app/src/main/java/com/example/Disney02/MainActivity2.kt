package com.example.Disney02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val image : ImageView = findViewById<ImageView>(R.id.image2)
        val description : TextView = findViewById(R.id.decription)
        val bundle :Bundle? = intent.extras
        val topImage = bundle!!.getString("image")
        val desc = bundle!!.getString("decription")

        description.text = desc
        //image.setImageResource(topImage)
        Glide.with(image.context).load(topImage).into(image)

    }
}