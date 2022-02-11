package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to a dice and view  the result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dices and update the screen with the result
     */
    private fun rollDice() {
        //Create new dice object with 6 and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Find the image in  layout
        val diceImage: ImageView = findViewById(R.id.imageView)
       /**
         * roll dice update statement used instead of if/else
        * Determine which drawable resource ID to use on the dice roll
        */
     val drawableResources = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
           //because android studio see when as an error (line 32), when must be exhaustive, therefore an else statement must be introduced
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResources)
        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}