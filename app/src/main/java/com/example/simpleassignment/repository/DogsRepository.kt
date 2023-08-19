package com.example.simpleassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simpleassignment.api.ApiService
import com.example.simpleassignment.db.DogDatabase
import com.example.simpleassignment.db.DogsDao
import com.example.simpleassignment.model.Dogs

class DogsRepository(private val dogsApi : ApiService,private val dogsDatabase: DogDatabase) {

    private val dogsLiveData = MutableLiveData<Dogs>()
    val dogs: LiveData<Dogs>
        get() = dogsLiveData

    private val recentDogsLiveData = MutableLiveData<List<Dogs>>()
    val recentDogs: LiveData<List<Dogs>>
        get() = recentDogsLiveData

    suspend fun getDogs() {
        val result = dogsApi.getItems()
        if(result.body() != null) {
            dogsDatabase.dogDao().insertDogs(result.body()!!)
            dogsLiveData.postValue(result.body())
        }
    }

    suspend fun deleteDogs() {
        dogsDatabase.dogDao().deleteAll()
    }

    suspend fun getDogsFromDatabase() {
       val dogs = dogsDatabase.dogDao().getDogs()
        recentDogsLiveData.postValue(dogs)
    }
}