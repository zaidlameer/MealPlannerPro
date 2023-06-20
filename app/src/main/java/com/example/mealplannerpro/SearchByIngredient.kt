package com.example.mealplannerpro

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class SearchByIngredient : AppCompatActivity() {
    private lateinit var tv: TextView
    private lateinit var btn: Button
    private lateinit var search: EditText
    private lateinit var saveBtn: Button


    var name: String =""
    private var drinkAlternate: String=""
    private var category : String=""
    private var area : String=""
    private var instructions : String=""
    private var thumb : String=""
    private var tags : String=""
    private var youtube : String=""

    private var ingredient1 : String=""
    private var ingredient2 : String=""
    private var ingredient3 : String=""
    private var ingredient4 : String=""
    private var ingredient5 : String=""
    private var ingredient6 : String=""
    private var ingredient7 : String=""
    private var ingredient8 : String=""
    private var ingredient9 : String=""
    private var ingredient10 : String=""
    private var ingredient11 : String=""
    private var ingredient12: String=""
    private var ingredient13 : String=""
    private var ingredient14 : String=""
    private var ingredient15 : String=""
    private var ingredient16: String=""
    private var ingredient17 : String=""
    private var ingredient18 : String=""
    private var ingredient19 : String=""
    private var ingredient20 : String=""

    private var measure1 : String=""
    private var measure2 : String=""
    private var measure3 : String=""
    private var measure4 : String=""
    private var measure5 : String=""
    private var measure6 : String=""
    private var measure7 : String=""
    private var measure8: String=""
    private var measure9 : String=""
    private var measure10 : String=""
    private var measure11 : String=""
    private var measure12 : String=""
    private var measure13 : String=""
    private var measure14  : String=""
    private var measure15  : String=""
    private var measure16 : String=""
    private var measure17 : String=""
    private var measure18 : String=""
    private var measure19 : String=""
    private var measure20 : String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_ingredient)

        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.retrieve_meals)
        search = findViewById(R.id.search_edit_text)
        saveBtn = findViewById(R.id.save_meals)


        btn.setOnClickListener {
            val searchQuery = search.text.toString()
            // Construct the URL with the search query
            val urlString = "https://www.themealdb.com/api/json/v1/1/search.php?s=$searchQuery"

            val url = URL(urlString)
            val con: HttpURLConnection = url.openConnection() as HttpURLConnection

            // Run the network request in a coroutine to avoid blocking the main thread
            runBlocking {
                launch {
                    // Run the code of the coroutine in a new thread
                    withContext(Dispatchers.IO) {
                        // Read the response from the API and store it in a StringBuilder
                        val bf = BufferedReader(InputStreamReader(con.inputStream))
                        val stb = StringBuilder()
                        var line: String? = bf.readLine()
                        while (line != null) {
                            stb.append(line + "\n")
                            line = bf.readLine()
                        }

                        // Parse the JSON response and display the meal information
                        parseJSON(stb)
                    }
                }
            }
        }

        saveBtn.setOnClickListener {
            saveMealsDB();
        }
    }



    private fun parseJSON(stb: StringBuilder) {
        // Create a JSON object from the response string
        val json = JSONObject(stb.toString())

        // Get the array of meals from the JSON object
        val mealArray = json.getJSONArray("meals")

        // Create a StringBuilder to hold the meal information
        val mealInfo = StringBuilder()
        // Loop through each meal object in the array
        for (i in 0 until mealArray.length()) {
            val mealObj = mealArray.getJSONObject(i)

            name = mealObj.getString("strMeal")
            drinkAlternate = mealObj.getString("strDrinkAlternate")
            category = mealObj.getString("strCategory")
            instructions = mealObj.getString("strInstructions")
            tags = mealObj.getString("strTags")
            youtube = mealObj.getString("strYoutube")

            ingredient1 = mealObj.getString("strIngredient1")
            ingredient2 = mealObj.getString("strIngredient2")
            ingredient3 = mealObj.getString("strIngredient3")
            ingredient4 = mealObj.getString("strIngredient4")
            ingredient5 = mealObj.getString("strIngredient5")
            ingredient6 = mealObj.getString("strIngredient6")
            ingredient7 = mealObj.getString("strIngredient7")
            ingredient8 = mealObj.getString("strIngredient8")
            ingredient9 = mealObj.getString("strIngredient9")
            ingredient10 = mealObj.getString("strIngredient10")
            ingredient11 = mealObj.getString("strIngredient11")
            ingredient12 = mealObj.getString("strIngredient12")
            ingredient13 = mealObj.getString("strIngredient13")
            ingredient14 = mealObj.getString("strIngredient14")
            ingredient15 = mealObj.getString("strIngredient15")
            ingredient16 = mealObj.getString("strIngredient16")
            ingredient17 = mealObj.getString("strIngredient17")
            ingredient18 = mealObj.getString("strIngredient18")
            ingredient19 = mealObj.getString("strIngredient19")
            ingredient20 = mealObj.getString("strIngredient20")

            measure1 = mealObj.getString("strMeasure1")
            measure2 = mealObj.getString("strMeasure2")
            measure3 = mealObj.getString("strMeasure3")
            measure4 = mealObj.getString("strMeasure4")
            measure5 = mealObj.getString("strMeasure5")
            measure6 = mealObj.getString("strMeasure6")
            measure7 = mealObj.getString("strMeasure7")
            measure8 = mealObj.getString("strMeasure8")
            measure9 = mealObj.getString("strMeasure9")
            measure10 = mealObj.getString("strMeasure10")
            measure11 = mealObj.getString("strMeasure11")
            measure12 = mealObj.getString("strMeasure12")
            measure13 = mealObj.getString("strMeasure13")
            measure14 = mealObj.getString("strMeasure14")
            measure15 = mealObj.getString("strMeasure15")
            measure16 = mealObj.getString("strMeasure16")
            measure17 = mealObj.getString("strMeasure17")
            measure18 = mealObj.getString("strMeasure18")
            measure19 = mealObj.getString("strMeasure19")
            measure20 = mealObj.getString("strMeasure20")



            // Append the meal information to the StringBuilder
            mealInfo.append("Meal: $name\n")
            mealInfo.append("Drink Alternate: $drinkAlternate\n")
            mealInfo.append("Category: $category\n")
            mealInfo.append("Instructions: $instructions\n")
            mealInfo.append("Tags: $tags\n")
            mealInfo.append("YouTube: $youtube\n")
            mealInfo.append("Ingredient1: $ingredient1\n")
            mealInfo.append("Ingredient2: $ingredient2\n")
            mealInfo.append("Ingredient3: $ingredient3\n")
            mealInfo.append("Ingredient4: $ingredient4\n")
            mealInfo.append("Ingredient5: $ingredient5\n")
            mealInfo.append("Ingredient6: $ingredient6\n")
            mealInfo.append("Ingredient7: $ingredient7\n")
            mealInfo.append("Ingredient8: $ingredient8\n")
            mealInfo.append("Ingredient9: $ingredient9\n")
            mealInfo.append("Ingredient10: $ingredient10\n")
            mealInfo.append("Ingredient11: $ingredient11\n")
            mealInfo.append("Ingredient12: $ingredient12\n")
            mealInfo.append("Ingredient13: $ingredient13\n")
            mealInfo.append("Ingredient14: $ingredient14\n")
            mealInfo.append("Ingredient15: $ingredient15\n")
            mealInfo.append("Ingredient16: $ingredient16\n")
            mealInfo.append("Ingredient17: $ingredient17\n")
            mealInfo.append("Ingredient18: $ingredient18\n")
            mealInfo.append("Ingredient19: $ingredient19\n")
            mealInfo.append("Ingredient20: $ingredient20\n")
            mealInfo.append("Measure1: $measure1\n")
            mealInfo.append("Measure2: $measure2\n")
            mealInfo.append("Measure3: $measure3\n")
            mealInfo.append("Measure4: $measure4\n")
            mealInfo.append("Measure5: $measure5\n")
            mealInfo.append("Measure6: $measure6\n")
            mealInfo.append("Measure7: $measure7\n")
            mealInfo.append("Measure8: $measure8\n")
            mealInfo.append("Measure9: $measure9\n")
            mealInfo.append("Measure10: $measure10\n")
            mealInfo.append("Measure11: $measure11\n")
            mealInfo.append("Measure12: $measure12\n")
            mealInfo.append("Measure13: $measure13\n")
            mealInfo.append("Measure14: $measure14\n")
            mealInfo.append("Measure15: $measure15\n")
            mealInfo.append("Measure16: $measure16\n")
            mealInfo.append("Measure17: $measure17\n")
            mealInfo.append("Measure18: $measure18\n")
            mealInfo.append("Measure19: $measure19\n")
            mealInfo.append("Measure20: $measure20\n\n")

        }

        runOnUiThread {
            // Display the meal information in the TextView
            tv.text = mealInfo.toString()
        }
    }
    private fun saveMealsDB(){
        // Accessing the database
        val db = Room.databaseBuilder(this, AppDatabase::class.java, "meal_db").build()
        val mealDao = db.mealDao()

        runBlocking {
            launch{
                // Saving in the DataBase
                // coroutine used to make sure data base executed in a non blocking manner
                val meals: List<Meal> = mealDao.getAll()
                val m = Meal(name, drinkAlternate, category, area, instructions, thumb ,tags, youtube,
                    ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6, ingredient7,
                    ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13,
                    ingredient14, ingredient15, ingredient16, ingredient17, ingredient18, ingredient19,
                    ingredient20, measure1, measure2, measure3, measure4, measure5, measure6, measure7,
                    measure8, measure9, measure10, measure11, measure12, measure13, measure14,
                    measure15, measure16, measure17, measure18, measure19)
                mealDao.insertMeal(m)


            }

}
}
}