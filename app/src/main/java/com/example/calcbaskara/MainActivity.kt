package com.example.calcbaskara

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnCalc : Button
    lateinit var etFormula : EditText
    lateinit var tvLineOnteTwo: TextView

    private lateinit var baskara: Baskara;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalc);
        etFormula = findViewById(R.id.etFormula);
        tvLineOnteTwo = findViewById(R.id.tvLineOnteTwo)
        btnCalc.setOnClickListener(::btnCalc);
    }

    private fun parserFormula() : Baskara{
        var formula = etFormula.text;

        var patternA = "((-|\\+)\\d+?x\\^\\d)|(\\d+?x\\^\\d)".toRegex();
        var patternB = "(-|\\+)(\\d+)x(-|\\+)".toRegex();
        var patternC = "(\\+|-)\\d+?=".toRegex();

        var a = patternA.findAll(formula).map{ it.value }.toList().joinToString("","","");

        var b = patternB.findAll(formula).map{ it.value }.toList().joinToString("","","");

        var c = patternC.findAll(formula).map{ it.value }.toList().joinToString("","","");

        var aDouble = Regex("x\\^\\d").replace(a, "").toDouble();

        var bDouble = Regex("x(-|\\+)").replace(b, "").toDouble();

        var cDouble = Regex("=").replace(c, "").toDouble();

        return Baskara(aDouble, bDouble, cDouble);
    }

    @SuppressLint("SetTextI18n")
    private fun btnCalc(view: View) {
        this.baskara = parserFormula();

        var lineOne: Double = this.baskara.l1();
        var lineTwo: Double = this.baskara.l2();

        tvLineOnteTwo.setText("S={ ${String.format("%.4f", lineOne)}, ${String.format("%.4f", lineTwo)} } ")

        Toast.makeText(applicationContext, etFormula.text,Toast.LENGTH_SHORT).show()
    }
}
