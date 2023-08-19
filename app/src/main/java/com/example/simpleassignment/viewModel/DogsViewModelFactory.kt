package com.example.simpleassignment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleassignment.repository.DogsRepository

class DogsViewModelFactory(private val dogsRepository: DogsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DogsViewModel(dogsRepository) as T
    }
}