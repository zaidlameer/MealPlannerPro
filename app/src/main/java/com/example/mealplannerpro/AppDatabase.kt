package com.example.mealplannerpro

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Meal::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun mealDao(): MealDao // returns meal dao object
    // creating the room database for storing all the data of the meal  class
    // configuration for the database
}