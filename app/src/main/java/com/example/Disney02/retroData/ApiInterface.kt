package com.example.Disney02.retroData

import com.example.Disney02.model.DATAItem
import com.example.Disney02.model.DataUsed
import retrofit2.http.GET

interface ApiInterface {
@GET("api/v1/products.json?brand=maybelline")
suspend fun getPost(): List<DataUsed>


}