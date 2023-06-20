package com.example.mealplannerpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SearchForMeals : AppCompatActivity() {
    private lateinit var searchBox: EditText
    private lateinit var searchBtn: Button
    private lateinit var resultsBox: TextView
    // look for meal names in the app database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_for_meals)

        searchBox = findViewById(R.id.search)
        searchBtn = findViewById(R.id.button4)
        resultsBox = findViewById(R.id.results)

        searchBtn.setOnClickListener {
            searchForMealsFromDB()
        }
    }

    private fun searchForMealsFromDB() {
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "meal_db").build()
        val mealDao = db.mealDao()

        val meal = searchBox.text.toString().trim().lowercase()

        if (meal.isEmpty()) return

        runBlocking {
            // run data base in non blocking manner
            val meals = withContext(Dispatchers.IO) { mealDao.getAllTitles(meal) }
            val mealTitles = meals.joinToString(separator = "\n\n") { it.mealName.toString() }
            resultsBox.text = mealTitles
        }
    }
}
