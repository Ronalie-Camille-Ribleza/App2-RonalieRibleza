package com.example.cookingutilityapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingredients.*

class Ingredients: AppCompatActivity() {
    lateinit var backButton: Button
    lateinit var enterButton: Button
    lateinit var removeButton: Button
    lateinit var ingredientName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        backButton = findViewById(R.id.mainMenu)
        backButton.setOnClickListener {
            val backToMenu = Intent(this, MainActivity::class.java)
            startActivity(backToMenu)
        }

        var ingredientList: MutableSet<String> = mutableSetOf()
        val pref = getSharedPreferences("name", 0)
        val ingredient = pref.getStringSet("ingredient", mutableSetOf()) as MutableSet<String>
        ingredientList.addAll(ingredient)
        addToScrollView(ingredientList)

        enterButton = findViewById(R.id.enterButton)
        enterButton.setOnClickListener{
            ingredientList.add(enterButton.text.toString())

            val editor = getSharedPreferences("ingredientList", 0).edit()
            editor.putStringSet("ingredient", ingredientList)
            editor.commit()

            addToScrollView(ingredientList)
        }

        removeButton = findViewById(R.id.deleteButton)
        removeButton.setOnClickListener{
            ingredientList.remove(deleteButton.text.toString())

            val editor = getSharedPreferences("ingredientList", 0).edit()
            editor.putStringSet("ingredient", ingredientList)
            editor.commit()

            addToScrollView(ingredientList)
        }
    }

    private fun addToScrollView(set : MutableSet<String>)
    {
        ingredientList.removeAllViews()
        for (item in set) {
            var textview = TextView(this)
            textview.text = item
            textview.textSize = 15f
            ingredientList.addView(textview)
        }
    }
}