package com.example.Disney02.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Disney02.R
import com.example.Disney02.model.DataUsed

class GridAdapter(var context: Context, val roomApi : List<DataUsed>) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

   private lateinit var mlistener : onItemClickListener

   interface onItemClickListener{
       fun onClicked(position: Int)
   }
    fun setonItemClickListener(listener:onItemClickListener){
           mlistener = listener
    }



    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById<TextView>(R.id.title)
        val Image : ImageView = itemView.findViewById<ImageView>(R.id.image)
        fun bind(dataUsed: DataUsed){
            Glide.with(Image.context).load(dataUsed.image_link).into(Image)
        }
        init {
            itemView.setOnClickListener {
                listener.onClicked(adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
        return ViewHolder(view,mlistener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(roomApi[position])
        val api =roomApi[position]
        holder.title.text = "${api.name}"



    }

    override fun getItemCount(): Int {
        return roomApi.size
    }
}