package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var Lemon_state = "Lemone_state"
    private val lemon_size = "Lemon_size"
    private val squeeze_count = "squeeze_count"
    private val select = "select"
    private val squeeze = "squeeze"
    private val drink = "drink"
    private val restart = "restart"
    private val lemonadeState = "select"
    private var size_lemon = 0
    private var squeezeCount = 0
    private val lemon_tree = LemonTree()
    private var lemon_Image = ImageView()

    private fun ImageView() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            Lemon_state = savedInstanceState.getString("Lemone_state", "select")
            size_lemon = savedInstanceState.getInt("Lemon_size", 0)
            squeezeCount = savedInstanceState.getInt("squeeze_count", 0)
        }
        lemon_Image = findViewById(R.id.imageView_state)
        setElements()
        lemon_Image!!.setOnLongClickListener {
         show()
        }
    }

    private fun show() {
       return countState
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(Lemon_state, lemonadeState)
        outState.putInt(lemon_size, size_lemon)
        outState.putInt(squeeze_count, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    private fun clickLemonImage() {
    // when(lemonadeState){
         "select"->
        // "squeeze" ->"click to jouce a lemon"
        // "drink" -> "click to drink lemonda"
        // "restart" ->"click to restart"
    // }
    }

    private fun setElements() {
        val textAction: TextView = findViewById(R.id.textAction)
        when(lemonadeState){
            "select"->"click on a lemon"
            "squeeze" ->"click to jouce a lemon"
            "drink" -> "click to drink lemonda"
            "restart" ->"click to restart"
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun showSnackbar(): Boolean {
        if (lemonadeState != squeeze)
            return false
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_layout),
                    squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

class LemonTree {
    fun pick(): Int {
        return (2..4).random()
    }
}


