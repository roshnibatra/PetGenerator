package com.example.simpleassignment

import android.app.Application
import com.example.simpleassignment.api.ApiService
import com.example.simpleassignment.api.RetrofitHelper
import com.example.simpleassignment.db.DogDatabase
import com.example.simpleassignment.repository.DogsRepository

class DogsApplication : Application() {

    lateinit var repository: DogsRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val dogDatabase = DogDatabase.getDatabase(applicationContext)
        val dogsApi = RetrofitHelper.getInstance().create(ApiService::class.java)
        repository = DogsRepository( dogsApi,dogDatabase)
    }
}