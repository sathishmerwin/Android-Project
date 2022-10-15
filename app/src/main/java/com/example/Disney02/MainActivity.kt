package com.example.Disney02
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Disney02.Adapter.GridAdapter
import com.example.Disney02.databinding.ActivityMainBinding
import com.example.Disney02.model.DataUsed

import com.example.Disney02.viewModel.ViewModelDisney
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    //private lateinit var postView : ViewModelDisney

   val viewModelDisney : ViewModelDisney by viewModels()
    private lateinit var List : List<DataUsed>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        viewModelDisney.responseData.observe(this,Observer{
            val data1 = it.toString()
            Log.d("tag", " data ???... .... ${it}")
//            Log.d("tag", " data is ... .... ${data1}")
         it.forEach {
             Log.d("tag", "indexof..${it.id} data is ... .... ${it.name}")
         }
            val adapter = GridAdapter(this,it)
            List = it
         val gridLayout = GridLayoutManager(this,2)

            recyclerView.layoutManager = gridLayout
            recyclerView.adapter = adapter

            adapter.setonItemClickListener(object : GridAdapter.onItemClickListener{
                override fun onClicked(position: Int) {
                    Toast.makeText(this@MainActivity,"Clicked On == ${position}",Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity,MainActivity2::class.java)
                    intent.putExtra("image",it[position].image_link)
                    intent.putExtra("decription",it[position].description)
                    startActivity(intent)
                }

            })




     })


    }


}


