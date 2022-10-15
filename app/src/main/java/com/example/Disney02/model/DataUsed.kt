package com.example.Disney02.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "RoomDB")
data class DataUsed(
    @PrimaryKey(autoGenerate = true)

    @SerializedName("id")
    val id :Int,
    @SerializedName("brand")
    val brand : String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_link")
    val image_link : String,
    @SerializedName("description")
    val description :String
)
