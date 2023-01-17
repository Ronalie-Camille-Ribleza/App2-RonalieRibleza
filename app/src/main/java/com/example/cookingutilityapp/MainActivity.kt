package com.example.cookingutilityapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ingredientButton: Button // lateinit suggest a variable that will be initialized
                                          // in the future
    lateinit var equipmentButton: Button
    lateinit var timerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingredientButton = findViewById(R.id.ingredientButton)
        equipmentButton = findViewById(R.id.equipmentButton)
        timerButton = findViewById(R.id.timerButton)

        ingredientButton.setOnClickListener {
            val goToIngredients = Intent(this, Ingredients::class.java)
            startActivity(goToIngredients)
        }

        equipmentButton.setOnClickListener {
            val goToEquipment = Intent(this, Equipment::class.java)
            startActivity(goToEquipment)
        }

        timerButton.setOnClickListener {
            val goToTimer = Intent(this, Timer::class.java)
            startActivity(goToTimer)
        }
    }
}