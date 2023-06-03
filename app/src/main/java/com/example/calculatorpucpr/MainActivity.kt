package com.example.calculatorpucpr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorpucpr.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val expressions = arrayOf("+", "-", "/", "*", "%")
    private val aux = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // clear button
        binding.clearButton.setOnClickListener { clearAll() }

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
        binding.buttonDot.setOnClickListener { incrementValue(".") }

        // expressions
        binding.buttonPlus.setOnClickListener { incrementValue("+") }
        binding.buttonMinus.setOnClickListener { incrementValue("-") }
        binding.buttonDivide.setOnClickListener { incrementValue("/") }
        binding.buttonPercent.setOnClickListener { incrementValue("%") }
        binding.buttonMultiple.setOnClickListener { incrementValue("*") }
        binding.buttonEquals.setOnClickListener { showResult() }
    }

    private fun showResult() {
        aux.append(binding.textViewExpression.text)
        val result = ExpressionBuilder(aux.toString()).build().evaluate()

        val decimalPart = result.toString().substringAfter('.')
        val decimalValue = decimalPart.toDouble()

        if (decimalValue > 0) {
            binding.textViewExpression.text = result.toString()
        } else {
            binding.textViewExpression.text = result.toInt().toString()
        }

    }

    private fun clearAll() {
        binding.textViewExpression.text = "0"
        aux.clear()
    }

    private fun incrementValue(value: String) {

        if (binding.textViewExpression.text.toString() == "0") {
            binding.textViewExpression.text = value
            return
        }

        if (expressions.contains(value)) {
            aux.append(binding.textViewExpression.text)
            aux.append(value)
            binding.textViewExpression.text = ""
            return
        } else {
            appendExpression(value)
        }
    }

    private fun appendExpression(value: String) {
        binding.textViewExpression.append(value)
    }

}