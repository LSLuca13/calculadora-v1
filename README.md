# Calculadora Científica 

# ALUNO: LUCA SOARES LIMA 

Este projeto é uma calculadora científica desenvolvida em Kotlin com Android Studio. A proposta foi criar uma interface funcional e moderna, parecida com a calculadora científica do Windows, utilizando apenas recursos nativos do Android.

## Funcionalidades

- Operações básicas: adição, subtração, multiplicação e divisão
- Operações científicas:
    - Raiz quadrada
    - Potência
    - Fatorial
    - Quadrado
- Funções trigonométricas:
    - seno (sin), cosseno (cos), tangente (tan)
- Logaritmos:
    - log (base 10)
    - ln (logaritmo natural)
- Constantes matemáticas:
    - pi (π)
    - número de Euler (e)
- Operações adicionais:
    - inverso (1/x)
    - ponto decimal
    - limpar (C) e limpar entrada (CE)
- Suporte a ScrollView para garantir visibilidade em telas menores

## Tecnologias utilizadas

- Kotlin
- Android Studio
- Componentes nativos do Android:
    - TextView, Button, TableLayout, LinearLayout, ScrollView

## Bibliotecas utilizadas

Não foram utilizadas bibliotecas externas. Toda a aplicação foi feita com bibliotecas nativas do Android e da linguagem Kotlin.

### Importações usadas no código:

```kotlin
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

