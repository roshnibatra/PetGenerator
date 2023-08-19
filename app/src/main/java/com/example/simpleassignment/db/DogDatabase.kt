package com.example.simpleassignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simpleassignment.model.Dogs


@Database(entities = [Dogs::class], version = 1)
abstract class DogDatabase : RoomDatabase() {

    abstract fun dogDao(): DogsDao

    companion object {
        var INSTANCE: DogDatabase? = null
        fun getDatabase(context: Context): DogDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context, DogDatabase::class.java, "dog_db")
                        .build()

                }
            }
            return INSTANCE!!
        }

    }
}