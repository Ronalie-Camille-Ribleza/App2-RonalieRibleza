package com.example.cookingutilityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_equipment.*

class Equipment : AppCompatActivity() {
    lateinit var backButton: Button
    lateinit var enterButton: Button
    lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)
        backButton = findViewById(R.id.mainMenu)
        backButton.setOnClickListener {
            val backToMenu = Intent(this, MainActivity::class.java)
            startActivity(backToMenu)
        }

        var equipmentList: MutableSet<String> = mutableSetOf()
        val pref = getSharedPreferences("name", 0)
        val ingredient = pref.getStringSet("ingredient", mutableSetOf()) as MutableSet<String>
        equipmentList.addAll(ingredient)
        addToScrollView(equipmentList)

        enterButton = findViewById(R.id.enterButton)
        enterButton.setOnClickListener{
            equipmentList.add(enterButton.text.toString())

            val editor = getSharedPreferences("ingredientList", 0).edit()
            editor.putStringSet("enterEquipment", equipmentList)
            editor.commit()

            addToScrollView(equipmentList)
        }

        removeButton = findViewById(R.id.deleteButton)
        removeButton.setOnClickListener{
            equipmentList.remove(deleteButton.text.toString())

            val editor = getSharedPreferences("ingredientList", 0).edit()
            editor.putStringSet("ingredient", equipmentList)
            editor.commit()

            addToScrollView(equipmentList)
        }
    }

    private fun addToScrollView(set : MutableSet<String>)
    {
        equipmentList.removeAllViews() //removes all existing views
        for (item in set) {
            var textview = TextView(this)
            textview.text = item //set the text
            textview.textSize = 15f
            equipmentList.addView(textview)
        }
    }
}