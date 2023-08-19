package com.example.simpleassignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleassignment.model.Dogs
import com.example.simpleassignment.repository.DogsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DogsViewModel(private val dogsRepository: DogsRepository): ViewModel() {

//    init {
//        viewModelScope.launch {
//            dogsRepository.getDogs()
//        }
//    }

    fun getDog() {
        GlobalScope.launch {
            dogsRepository.getDogs()
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            dogsRepository.deleteDogs()
        }
    }

    fun readFromDatabase() {
        viewModelScope.launch {
            dogsRepository.getDogsFromDatabase()
        }
    }

    val dogs : LiveData<Dogs>
        get() = dogsRepository.dogs

    val recentDogs : LiveData<List<Dogs>>
        get() = dogsRepository.recentDogs
}