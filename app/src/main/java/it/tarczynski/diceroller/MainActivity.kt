package it.tarczynski.diceroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        rollButton.setOnClickListener { rollDice(diceImage) }
    }

    private fun rollDice(diceImage: ImageView) {
        val resource = when (Random.nextInt(diceLowerBound, diceUpperBoundExclusive)) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(resource)
    }

    companion object DiceBounds {
        const val diceLowerBound = 1
        const val diceUpperBoundExclusive = 7
    }
}
