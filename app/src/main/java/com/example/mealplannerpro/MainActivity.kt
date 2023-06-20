package com.example.mealplannerpro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
// Testing one
// Testing two
class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.add)
        val searchIngredient = findViewById<Button>(R.id.searchi)
        val searchMeal = findViewById<Button>(R.id.searchm)

        // create a new database instance
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "meal_db"
        ).fallbackToDestructiveMigration() // Allow destructive migration
            .build()

        val mealDao = db.mealDao()

        // Button to add the contents to the dataBase
        addBtn.setOnClickListener {
        GlobalScope.launch(Dispatchers.IO) {
            val meal = Meal("Sweet and Sour Pork",
            null,
            "Pork",
            "Chinese",
            "Preparation\r\n1. Crack the egg into a bowl. Separate the egg white and yolk.\r\n\r\nSweet and Sour Pork\r\n2. Slice the pork tenderloin into ips.\r\n\r\n3. Prepare the marinade using a pinch of salt, one teaspoon of starch, two teaspoons of light soy sauce, and an egg white.\r\n\r\n4. Marinade the pork ips for about 20 minutes.\r\n\r\n5. Put the remaining starch in a bowl. Add some water and vinegar to make a starchy sauce.\r\n\r\nSweet and Sour Pork\r\nCooking Inuctions\r\n1. Pour the cooking oil into a wok and heat to 190\u00b0C (375\u00b0F). Add the marinated pork ips and fry them until they turn brown. Remove the cooked pork from the wok and place on a plate.\r\n\r\n2. Leave some oil in the wok. Put the tomato sauce and white sugar into the wok, and heat until the oil and sauce are fully combined.\r\n\r\n3. Add some water to the wok and thoroughly heat the sweet and sour sauce before adding the pork ips to it.\r\n\r\n4. Pour in the starchy sauce. Stir-fry all the ingredients until the pork and sauce are thoroughly mixed together.\r\n\r\n5. Serve on a plate and add some coriander for decoration.",
                "https://www.youtube.com//watch?v=mdaBIhgEAMo",
            "Sweet",
            "Pork",
            "Egg",
            "Water",
            "Salt",
            "Sugar",
            "Soy Sauce",
            "Starch",
            "Tomato Puree",
            "Vinegar",
            "Coriander",
                null,null,null,null,null,null,null,null,null,null,
            "200g",
            "1",
            "Dash",
            "1/2 tsp",
            "1 tsp ",
            "10g",
            "10g",
            "30g",
            "10g",
            "Dash",null,null,null,null,null,null,null,null,null,null)

            val meal2 = Meal("Chicken Marengo",
            null,
            "Chicken",
            "French",
            "Heat the oil in a large flameproof casserole dish and stir-fry the mushrooms until they start to soften. Add the chicken legs and cook briefly on each side to colour them a little.\r\nPour in the passata, crumble in the stock cube and stir in the olives. Season with black pepper \u2013 you shouldn\u2019t need salt. Cover and simmer for 40 mins until the chicken is tender. Sprinkle with parsley and serve with pasta and a salad, or mash and green veg, if you like.",
                "https://www.youtube.com//watch?v=U33HYUr-0Fw",null,
            "Olive Oil",
            "Mushrooms",
            "Chicken Legs",
            "Passata",
            "Chicken Stock Cube",
            "Black Olives",
            "Parsley",null,null,null,null,null,null,null,null,null,null,null,null,null,
            "1 tbs",
            "300g",
            "4",
            "500g",
            "1",
            "100g ",
            "Chopped",null,null,null,null,null,null,null,null,null,null,null,null,null
            )

            val meal3 = Meal("Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
            null,
            "Beef",
            "Vietnamese",
            "Add'l ingredients: mayonnaise, siracha\r\n\r\n1\r\n\r\nPlace rice in a fine-mesh sieve and rinse until water runs clear. Add to a small pot with 1 cup water (2 cups for 4 servings) and a pinch of salt. Bring to a boil, then cover and reduce heat to low. Cook until rice is tender, 15 minutes. Keep covered off heat for at least 10 minutes or until ready to serve.\r\n\r\n2\r\n\r\nMeanwhile, wash and dry all produce. Peel and finely chop garlic. Zest and quarter lime (for 4 servings, zest 1 lime and quarter both). Trim and halve cucumber lengthwise; thinly slice crosswise into half-moons. Halve, peel, and medium dice onion. Trim, peel, and grate carrot.\r\n\r\n3\r\n\r\nIn a medium bowl, combine cucumber, juice from half the lime, \u00bc tsp sugar (\u00bd tsp for 4 servings), and a pinch of salt. In a small bowl, combine mayonnaise, a pinch of garlic, a squeeze of lime juice, and as much sriracha as you\u2019d like. Season with salt and pepper.\r\n\r\n4\r\n\r\nHeat a drizzle of oil in a large pan over medium-high heat. Add onion and cook, stirring, until softened, 4-5 minutes. Add beef, remaining garlic, and 2 tsp sugar (4 tsp for 4 servings). Cook, breaking up meat into pieces, until beef is browned and cooked through, 4-5 minutes. Stir in soy sauce. Turn off heat; taste and season with salt and pepper.\r\n\r\n5\r\n\r\nFluff rice with a fork; stir in lime zest and 1 TBSP butter. Divide rice between bowls. Arrange beef, grated carrot, and pickled cucumber on top. Top with a squeeze of lime juice. Drizzle with sriracha mayo.",
            "",
            null,
            "Rice",
            "Onion",
            "Lime",
            "Garlic Clove",
            "Cucumber",
            "Carrots",
            "Ground Beef",
            "Soy Sauce",null,null,null,null,null,null,null,null,null,null,null,null,
            "White",
            "1",
            "1",
            "3",
            "1",
            "3 oz ",
            "1 lb",
            "2 oz ",
                null,null,null,null,null,null,null,null,null,null,null,null
            )

            val meal4 =  Meal("Leblebi Soup",
            null,
            "Vegetarian",
            "Tunisian",
            "Heat the oil in a large pot. Add the onion and cook until translucent.\r\nDrain the soaked chickpeas and add them to the pot together with the vegetable stock. Bring to the boil, then reduce the heat and cover. Simmer for 30 minutes.\r\nIn the meantime toast the cumin in a small ungreased frying pan, then grind them in a mortar. Add the garlic and salt and pound to a fine paste.\r\nAdd the paste and the harissa to the soup and simmer until the chickpeas are tender, about 30 minutes.\r\nSeason to taste with salt, pepper and lemon juice and serve hot.",
                "https://www.youtube.com//watch?v=BgRifcCwinY",
            "Soup",
            "Olive Oil",
            "Onion",
            "Chickpeas",
            "Vegetable Stock",
            "Cumin",
            "Garlic",
            "Salt",
            "Harissa Spice",
            "Pepper",
            "Lime",null,null,null,null,null,
                null,null,null,null,null,
            "2 tbs",
            "1 medium finely diced",
            "250g",
            "1.5L",
            "1 tsp ",
            "5 cloves",
            "1/2 tsp",
            "1 tsp ",
            "Pinch",
            "1/2 ",null,null,null,null,null,
                null,null,null,null,null
            )

            mealDao.insertMeal(meal, meal2, meal3, meal4)
//            mealDao.insertMeals(meal, meal2, meal3, meal4)
//            val users: List<Meal> = mealDao.getAll()
//            for (u in users) {
//                tv.append("\n ${u.mealName}")
//            }
        }
        }
        searchIngredient.setOnClickListener {
            val searchIntent = Intent(this, SearchByIngredient:: class.java)
            startActivity(searchIntent)
        }
        searchMeal.setOnClickListener {
            val searchIntent = Intent(this, SearchForMeals:: class.java)
            startActivity(searchIntent)

        }
    }
}

