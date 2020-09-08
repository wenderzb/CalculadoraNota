package com.example.notacalc

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcular( v : View) {

        if (et_nome.text.toString() == "" || et_nota1.text.toString() == "" || et_nota2.text.toString() == ""){
            tv_resultado.visibility = View.VISIBLE
            tv_resultado.text = "Por favor digite os dados!"
        }else{
            val nome = et_nome.text.toString()
            val nota1 = et_nota1.text.toString().toDouble()
            val nota2 = et_nota2.text.toString().toDouble()

            et_nome.backgroundTintList = ColorStateList.valueOf(Color.parseColor(validacaoNome(nome)));
            et_nota1.backgroundTintList = ColorStateList.valueOf(Color.parseColor(validacaoNota(nota1)));
            et_nota2.backgroundTintList = ColorStateList.valueOf(Color.parseColor(validacaoNota(nota2)));

            tv_resultado.visibility = View.VISIBLE

            if(validacaoNome(nome) == "#ff5252" || validacaoNota(nota1) == "#ff5252" ||  validacaoNota(nota2) == "#ff5252"){
                tv_resultado.setTextColor(Color.parseColor("#ff5252"))
                tv_resultado.text = "Por favor digite os dados corretamente"
            }else {
                val calculo = (nota1 + nota2) / 2

                val resultado = situacaoFinal(calculo)

                val corTvResultado = if(resultado == "Reprovado(a)") "#ff5252" else "#90ee90"

                tv_resultado.setTextColor(Color.parseColor(corTvResultado))
                tv_resultado.text =
                    "${nome} sua nota final foi ${String.format("%.2f", calculo)}, você foi ${resultado}."



            }

        }

    }

    fun validacaoNome(texto:String): String {

        val caracteres = texto.length;
        var validacao = if(caracteres < 3 || caracteres > 20 ) "#ff5252" else "#ffffff";

        return validacao;

    }

    fun validacaoNota(numero:Double):String{

        val validacao = if(numero < 0 || numero > 10) "#ff5252" else "#ffffff"

        return validacao;

    }

    fun situacaoFinal(numero:Double):String {
        val situacao = if(numero < 5) "Reprovado(a)" else "Aprovado(a)"

        return situacao;
    }

}