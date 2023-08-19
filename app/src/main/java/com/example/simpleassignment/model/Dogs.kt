package com.example.simpleassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dogs")
data class Dogs(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val message: String,
    val status: String
)