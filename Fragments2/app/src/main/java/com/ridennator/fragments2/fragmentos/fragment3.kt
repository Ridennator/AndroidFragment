package com.ridennator.fragments2.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ridennator.fragments2.R
import kotlin.random.Random


class fragment3 : Fragment() {

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?)
        :View?{
            return inflater.inflate(R.layout.fragment_fragment3,container,false)
        }
    //find button
    var rollDicebt: Button =findViewById(R.id.GenerateNumberButton)
    //define that the button will react to click
    rollDicebt.setOnClickListener{
        //add a message to screen when you press the button
        Toast.makeText(this,"The button was pressed", Toast.LENGTH_SHORT).show()
        rollDice()
    }
    diceImage = findViewById<ImageView>(R.id.DiceView)


private fun rollDice() {
    var randomValue = Random.nextInt(6)+1
    var resultText = findViewById<TextView>(R.id.GeneratedNumberView)
    resultText.text=randomValue.toString()

    //choose the dice image
    var drawableResource = when(randomValue){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        6->R.drawable.dice_6

        else -> {R.drawable.empty_dice}
    }
    // assign image
    //var diceImage=findViewById<ImageView>(R.id.DiceView)
    diceImage.setImageResource(drawableResource)
}
}