package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private var variableFirst = 0.0
    private var variableSecond = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        init()
    }

    private fun init() {
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonDot.setOnClickListener {
            if (resultTextView.text.isNotEmpty() && "." !in resultTextView.text.toString()) {
                resultTextView.text = resultTextView.text.toString() + "."
            }
        }
    }


    fun equal(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            variableSecond = value.toDouble()
            operation()

        }
    }

    private fun operation() {
        var result = 0.0
        if (operation == divideButton.text.toString() && variableSecond == 0.0) {
            Toast.makeText(this, "division by 0 is impossible!", Toast.LENGTH_SHORT).show()
            resultTextView.text = ""
        } else if (operation == divideButton.text.toString()) {
            result = variableFirst / variableSecond
        } else if (operation == multiplyButton.text.toString()) {
            result = variableFirst * variableSecond
        } else if (operation == minusButton.text.toString()) {
            result = variableFirst - variableSecond
        } else if (operation == plusButton.text.toString()) {
            result = variableFirst + variableSecond
        }

        resultTextView.text = result.toString()
    }


    fun divide(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = value.toDouble()
            operation = divideButton.text.toString()
            resultTextView.text = ""
        }
    }


    fun multiply(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = value.toDouble()
            operation = multiplyButton.text.toString()
            resultTextView.text = ""
        }

    }

    fun minus(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = value.toDouble()
            operation = minusButton.text.toString()
            resultTextView.text = ""
        }
    }

    fun plus(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = value.toDouble()
            operation = plusButton.text.toString()
            resultTextView.text = ""
        }
    }


    fun delete(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty())
            resultTextView.text = value.substring(0, value.length - 1)
        longClickDelete()

    }

    fun longClickDelete() {
        if (resultTextView.text.isNotEmpty())
            resultTextView.text = ""
    }


    override fun onClick(v: View?) {
        val button: Button = v as Button
        resultTextView.text = resultTextView.text.toString() + button.text.toString()

    }

}