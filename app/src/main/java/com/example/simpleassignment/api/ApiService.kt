package com.example.simpleassignment.api

import com.example.simpleassignment.model.Dogs
import retrofit2.Response
import retrofit2.http.GET

interface ApiService  {

    @GET("/api/breeds/image/random")
    suspend fun getItems() : Response<Dogs>
}