package com.example.simpleassignment.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.simpleassignment.model.Dogs
import retrofit2.http.DELETE

@Dao
interface DogsDao {

    @Query("SELECT * from Dogs order by id desc LIMIT 20")
    suspend fun getDogs() : List<Dogs>

    @Insert
    suspend fun insertDogs(result: Dogs)

    @Query("DELETE from Dogs")
    suspend fun deleteAll()
}