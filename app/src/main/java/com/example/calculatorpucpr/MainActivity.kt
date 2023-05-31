package com.example.calculatorpucpr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorpucpr.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expressions = arrayOf("+", "-", "/", "*", "%", "=")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // clear button
        binding.clearButton.setOnClickListener { binding.textViewResult.text = "0" }

        // numbers
        binding.buttonZero.setOnClickListener { incrementValue("0") }
        binding.buttonOne.setOnClickListener { incrementValue("1") }
        binding.buttonTwo.setOnClickListener { incrementValue("2") }
        binding.buttonThree.setOnClickListener { incrementValue("3") }
        binding.buttonFour.setOnClickListener { incrementValue("4") }
        binding.buttonFive.setOnClickListener { incrementValue("5") }
        binding.buttonSix.setOnClickListener { incrementValue("6") }
        binding.buttonSeven.setOnClickListener { incrementValue("7") }
        binding.buttonEight.setOnClickListener { incrementValue("8") }
        binding.buttonNine.setOnClickListener { incrementValue("9") }

        // expressions
        binding.buttonPlus.setOnClickListener { incrementValue("+") }
        binding.buttonDot.setOnClickListener { incrementValue(".") }
        binding.buttonEquals.setOnClickListener { incrementValue("=") }
    }

    private fun incrementValue(value: String) {
        if (binding.textViewResult.text.toString() == "0") {
            binding.textViewResult.text = value
            return
        }

        if (expressions.contains(value)) {
            return
        } else {
            appendExpression(value)
        }
    }

    private fun appendExpression(value: String) {
        binding.textViewResult.append(value)
    }

}