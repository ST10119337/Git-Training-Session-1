package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var num1EditText: EditText
    private lateinit var num2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1EditText = findViewById(R.id.num1EditText)
        num2EditText = findViewById(R.id.num2EditText)
        resultTextView = findViewById(R.id.resultTextView)

        val addButton: Button = findViewById(R.id.addButton)
        val subtractButton: Button = findViewById(R.id.subtractButton)
        val multiplyButton: Button = findViewById(R.id.multiplyButton)
        val divideButton: Button = findViewById(R.id.divideButton)

        addButton.setOnClickListener { calculate('+') }
        subtractButton.setOnClickListener { calculate('-') }
        multiplyButton.setOnClickListener { calculate('*') }
        divideButton.setOnClickListener { calculate('/') }
    }

    private fun calculate(operator: Char) {
        val num1 = num1EditText.text.toString().toDoubleOrNull()
        val num2 = num2EditText.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultTextView.text = "Invalid input"
            return
        }

        val result = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    resultTextView.text = "Error: Division by zero"
                    return
                }
            }
            else -> {
                resultTextView.text = "Invalid operator"
                return
            }
        }
        resultTextView.text = "Result: $result"
    }
}
