package com.example.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textView6: TextView
    lateinit var editText: EditText
    lateinit var resetButton: Button
    lateinit var guessButton: Button

    var random: Int = nextInt(5, 6)
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView6 = findViewById(R.id.textView6)
        editText = findViewById(R.id.editText)
        resetButton = findViewById(R.id.resetButton)
        guessButton = findViewById(R.id.guessButton)

        textView.text = "Enter the number in your mind!?"

        guessButton.setOnClickListener {

            val number: Int = editText.text.toString().toInt()

            if( number < random ){

                textView6.text = ""
                count++
                textView.text = "Unlucky,It's too low!!"
                editText.text.clear()

            }else if( number > random ){

                textView6.text = ""
                count++
                textView.text = "Unlucky,It's too high!!"
                editText.text.clear()

            }else{

                textView6.text = ""
                count++
                textView.text = "You have used $count attempts"
                textView6.text = "Very good!!"
                reset()
            }

        }

        resetButton.setOnClickListener {
            textView.text = "just $count attempts? C'mon! Fighting!!"
            textView6.text = "Secret number is $random"
            reset()

        }

    }
    fun reset(){
        random = nextInt(5, 6)
        count = 0
        editText.text.clear()
    }
}