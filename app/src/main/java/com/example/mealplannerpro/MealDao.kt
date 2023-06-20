package com.example.mealplannerpro

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {
    // dao means data access object
    @Insert
    suspend fun insertAll(vararg meals: Meal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(vararg meals: Meal)
    // onConflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMeals(meals: List<Meal>)

    @Query("SELECT * FROM Meal")
    suspend fun getAll(): List<Meal>

    @Query("SELECT * FROM Meal WHERE mealName LIKE '%' || :name || '%'")
    suspend fun getAllTitles(name: String): List<Meal>


}