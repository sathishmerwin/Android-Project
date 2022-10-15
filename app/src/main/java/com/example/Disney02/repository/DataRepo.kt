package com.example.Disney02.repository
import androidx.lifecycle.LiveData
import com.example.Disney02.model.DATA
import com.example.Disney02.model.DATAItem
import com.example.Disney02.model.DataUsed
import com.example.Disney02.retroData.ApiImplement
import com.example.Disney02.roomDb.RoomDaoImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class DataRepo @Inject constructor(private val apiImplement: ApiImplement, private val roomDaoImp: RoomDaoImp) {
    fun getPost1(): kotlinx.coroutines.flow.Flow<List<DataUsed>> = flow {
        var getList = roomDaoImp.getRetroinfo()
        if(getList.size > 0){
            emit(getList)
        }
        else{
            val response = apiImplement.getPost()
            roomDaoImp.insertRetroInfo(response)
            getList = roomDaoImp.getRetroinfo()
            emit(getList)
        }

    }.flowOn(Dispatchers.IO)

}


//fun getPost(): kotlinx.coroutines.flow.Flow<List<Data>> = flow {
//    var getheList= disneyDeoImp.getDisneyInfo()
//    //val response = postServicesImp.getPost().data
//    if(getheList.size>0){
//        emit(getheList)
//    } else{
//        val response = postServicesImp.getPost().data
//        disneyDeoImp.insertChar(response)
//        getheList = disneyDeoImp.getDisneyInfo()
//        emit(getheList)
//    }
//}.flowOn(Dispatchers.IO)