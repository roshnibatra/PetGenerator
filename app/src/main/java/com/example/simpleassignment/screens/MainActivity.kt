package com.example.simpleassignment.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.simpleassignment.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val generateButton = findViewById<TextView>(R.id.generate)
        val recentDogsButton = findViewById<TextView>(R.id.recentDogs)

        generateButton.setOnClickListener {
            val intent = Intent(this, DogGeneratingActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        recentDogsButton.setOnClickListener {
            val intent = Intent(this, RecentDogs::class.java)
            // start your next activity
            startActivity(intent)
        }
    }


}