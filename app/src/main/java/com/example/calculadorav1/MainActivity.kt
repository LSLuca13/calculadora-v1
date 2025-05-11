package com.example.calculadorav1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var valorAtual = ""
    private var operacao = ""
    private var memoria = 0.0
    private var isNovoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DISPLAY
        display = findViewById(R.id.display)

        // NÚMEROS
        val botoesNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        botoesNumeros.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                val digito = (it as Button).text.toString()
                if (isNovoNumero) {
                    valorAtual = digito
                    isNovoNumero = false
                } else {
                    valorAtual += digito
                }
                display.text = valorAtual
            }
        }

        // PONTO
        findViewById<Button>(R.id.btnPonto).setOnClickListener {
            if (!valorAtual.contains(".")) {
                valorAtual += if (valorAtual.isEmpty()) "0." else "."
                display.text = valorAtual
            }
        }

        // OPERAÇÕES BÁSICAS
        findViewById<Button>(R.id.btnMais).setOnClickListener { prepararOperacao("+") }
        findViewById<Button>(R.id.btnMenos).setOnClickListener { prepararOperacao("-") }
        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener { prepararOperacao("*") }
        findViewById<Button>(R.id.btnDividir).setOnClickListener { prepararOperacao("/") }

        // IGUAL
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            calcularResultado()
        }

        // LIMPAR
        findViewById<Button>(R.id.btnCE).setOnClickListener {
            valorAtual = ""
            display.text = "0"
        }

        findViewById<Button>(R.id.btnC).setOnClickListener {
            valorAtual = ""
            memoria = 0.0
            operacao = ""
            display.text = "0"
        }

        // OPERAÇÕES AVANÇADAS
        findViewById<Button>(R.id.btnRaiz).setOnClickListener {
            valorAtual = sqrt(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnQuadrado).setOnClickListener {
            valorAtual = (valorAtual.toDouble().pow(2)).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnFatorial).setOnClickListener {
            valorAtual = fatorial(valorAtual.toInt()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnPotencia).setOnClickListener {
            prepararOperacao("^")
        }

        // TRIGONOMETRIA
        findViewById<Button>(R.id.btnSen).setOnClickListener {
            valorAtual = sin(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnCos).setOnClickListener {
            valorAtual = cos(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnTan).setOnClickListener {
            valorAtual = tan(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        // CONSTANTES
        findViewById<Button>(R.id.btnPi).setOnClickListener {
            valorAtual = PI.toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnE).setOnClickListener {
            valorAtual = E.toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        // LOGARITMOS
        findViewById<Button>(R.id.btnLn).setOnClickListener {
            valorAtual = ln(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        findViewById<Button>(R.id.btnLog).setOnClickListener {
            valorAtual = log10(valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }

        // INVERSO
        findViewById<Button>(R.id.btnInverso).setOnClickListener {
            valorAtual = (1 / valorAtual.toDouble()).toString()
            display.text = valorAtual
            isNovoNumero = true
        }
    }

    // BLOCO: PREPARAR OPERAÇÃO
    private fun prepararOperacao(op: String) {
        memoria = valorAtual.toDouble()
        operacao = op
        isNovoNumero = true
    }

    // BLOCO: CALCULAR RESULTADO
    private fun calcularResultado() {
        val segundoValor = valorAtual.toDouble()
        val resultado = when (operacao) {
            "+" -> memoria + segundoValor
            "-" -> memoria - segundoValor
            "*" -> memoria * segundoValor
            "/" -> memoria / segundoValor
            "^" -> memoria.pow(segundoValor)
            else -> segundoValor
        }
        valorAtual = resultado.toString()
        display.text = valorAtual
        isNovoNumero = true
    }

    // BLOCO: FATORIAL
    private fun fatorial(n: Int): Long {
        return if (n <= 1) 1 else n * fatorial(n - 1)
    }
}
