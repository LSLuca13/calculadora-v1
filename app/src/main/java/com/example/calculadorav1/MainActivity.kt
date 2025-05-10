package com.example.calculadorav1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var temp1 = 0.0
    private var operacao = 0
    private var isResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        val btnPonto = findViewById<Button>(R.id.btnPonto)
        val btnCE = findViewById<Button>(R.id.btnCE)
        val btnC = findViewById<Button>(R.id.btnC)
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnIgual = findViewById<Button>(R.id.btnIgual)

        val buttons = listOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        for (btn in buttons) {
            btn.setOnClickListener {
                if (display.text == "0" || isResult) {
                    display.text = btn.text
                } else {
                    display.append(btn.text)
                }
                isResult = false
            }
        }

        btnPonto.setOnClickListener {
            if (!display.text.contains(".")) {
                display.append(".")
            }
        }

        btnCE.setOnClickListener {
            display.text = "0"
        }

        btnC.setOnClickListener {
            display.text = "0"
            temp1 = 0.0
            operacao = 0
            isResult = false
        }

        btnMais.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 1
            isResult = true
        }

        btnMenos.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 2
            isResult = true
        }

        btnMultiplicar.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 3
            isResult = true
        }

        btnDividir.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 4
            isResult = true
        }

        btnIgual.setOnClickListener {
            val temp2 = display.text.toString().toDoubleOrNull() ?: 0.0
            val result = when (operacao) {
                1 -> temp1 + temp2
                2 -> temp1 - temp2
                3 -> temp1 * temp2
                4 -> if (temp2 != 0.0) temp1 / temp2 else Double.NaN
                else -> temp2
            }
            display.text = if (result.isNaN()) "Erro" else result.toString()
            isResult = true
        }
    }
}
