package com.example.Disney02.retroData

import com.example.Disney02.model.DATAItem
import com.example.Disney02.model.DataUsed
import javax.inject.Inject

class ApiImplement @Inject constructor(private val apiInterface: ApiInterface) {

suspend fun getPost():List<DataUsed> = apiInterface.getPost()
}