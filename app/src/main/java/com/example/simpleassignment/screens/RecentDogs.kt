package com.example.simpleassignment.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.simpleassignment.DogsApplication
import com.example.simpleassignment.R
import com.example.simpleassignment.ViewPagerAdapter
import com.example.simpleassignment.viewModel.DogsViewModel
import com.example.simpleassignment.viewModel.DogsViewModelFactory


class RecentDogs : AppCompatActivity() {
    lateinit var viewModel: DogsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_dogs)

        val deleteDogs = findViewById<TextView>(R.id.deleteDogs)

        val repository = (application as DogsApplication).repository

        viewModel = ViewModelProvider(this, DogsViewModelFactory(repository))[DogsViewModel::class.java]



        val viewPager = findViewById<ViewPager2>(R.id.vp2)

        setupViewPager2(viewModel,viewPager)
        deleteDogs.setOnClickListener {
            viewModel.deleteAll()
            viewPager.visibility = View.GONE

        }

    }

    private fun setupViewPager2(viewModel: DogsViewModel, viewPager: ViewPager2) {
       viewModel.readFromDatabase()
        viewModel.recentDogs.observe(this, Observer {
            Log.d("TAG", it.toString())
            viewPager.clipToPadding = false
            viewPager.clipChildren = false
            viewPager.offscreenPageLimit = 2
            viewPager.adapter = ViewPagerAdapter(this,it)
        })



    }


}