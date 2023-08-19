package com.example.simpleassignment.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.simpleassignment.DogsApplication
import com.example.simpleassignment.R
import com.example.simpleassignment.api.ApiService
import com.example.simpleassignment.api.RetrofitHelper
import com.example.simpleassignment.db.DogDatabase
import com.example.simpleassignment.repository.DogsRepository
import com.example.simpleassignment.viewModel.DogsViewModel
import com.example.simpleassignment.viewModel.DogsViewModelFactory
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DogGeneratingActivity : AppCompatActivity() {

    lateinit var viewModel: DogsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_generating)

        val generateDogs = findViewById<TextView>(R.id.generateDogs)
        val dogsImage = findViewById<ImageView>(R.id.dogsImage)

        val repository = (application as DogsApplication).repository

        viewModel = ViewModelProvider(this,DogsViewModelFactory(repository))[DogsViewModel::class.java]
        viewModel.dogs.observe(this,Observer {
            Log.d("MainActivity",it.message)
            Glide.with(this)
                    .load(it.message)
                    .fitCenter()
                    .into(dogsImage)
        })

        generateDogs.setOnClickListener {
            viewModel.getDog()
        }

    }
}