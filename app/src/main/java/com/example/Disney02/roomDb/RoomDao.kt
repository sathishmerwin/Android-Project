package com.example.Disney02.roomDb


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Disney02.model.DataUsed
import retrofit2.http.DELETE


@Dao
interface RoomDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertRetroData(retroData:List<DataUsed>)
@Query("SELECT * FROM RoomDB")
suspend fun getALL():List<DataUsed>
//@DELETE
//suspend fun delete(dataUsed: DataUsed)


}