package com.example.cookingutilityapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timer.*

class Timer: AppCompatActivity() {
    lateinit var backButton: Button
    lateinit var timeLeft: TextView
    lateinit var timerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        timeLeft = findViewById(R.id.time)
        backButton = findViewById(R.id.mainMenu)
        backButton.setOnClickListener {
            val backToMenu = Intent(this, MainActivity::class.java)
            startActivity(backToMenu)
        }

        timerButton = findViewById(R.id.startButton)
        timerButton.setOnClickListener{
            object: CountDownTimer(600001, 1000){
                override fun onTick(millisUntilFinished: Long) {
                    timeLeft.setText("" + millisUntilFinished / 1000)
                }

                override fun onFinish() {
                    timeLeft.setText("Done")
                }
            }.start()
        }
    }
}