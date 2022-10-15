package com.example.Disney02.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.Disney02.model.DATAItem
import com.example.Disney02.model.DataUsed
import com.example.Disney02.repository.DataRepo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDisney @Inject constructor(private val dataRepo: DataRepo): ViewModel() {
    //var mutableLiveData:List<DataUsed> by mutableSetOf(listOf())

    val responseData : LiveData<List<DataUsed>> =dataRepo.getPost1()

    .catch {  ERROR ->
            Log.d("tag", " Error : ${ERROR.message}")
        }.asLiveData()

}




