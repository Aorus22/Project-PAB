package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var chartImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chartImageView = findViewById(R.id.chartImageView)

        val buttonTeknik = findViewById<Button>(R.id.buttonTeknik)
        val buttonPertanian = findViewById<Button>(R.id.buttonPertanian)
        val buttonMIPA = findViewById<Button>(R.id.buttonMIPA)
        val buttonKedokteran = findViewById<Button>(R.id.buttonKedokteran)
        val buttonIlmuPendidikan = findViewById<Button>(R.id.buttonIlmuPendidikan)
        val buttonPascaSarjana = findViewById<Button>(R.id.buttonPascaSarjana)
        val buttonHukum = findViewById<Button>(R.id.buttonHukum)
        val buttonIlmuBudaya = findViewById<Button>(R.id.buttonIlmuBudaya)

        buttonTeknik.setOnClickListener { changeChartImage(R.drawable.chart_dummy_1) }
        buttonPertanian.setOnClickListener { changeChartImage(R.drawable.chart_dummy_2) }
        buttonMIPA.setOnClickListener { changeChartImage(R.drawable.chart_dummy_3) }
        buttonKedokteran.setOnClickListener { changeChartImage(R.drawable.chart_dummy_4) }
        buttonIlmuPendidikan.setOnClickListener { changeChartImage(R.drawable.chart_dummy_1) }
        buttonPascaSarjana.setOnClickListener { changeChartImage(R.drawable.chart_dummy_2) }
        buttonHukum.setOnClickListener { changeChartImage(R.drawable.chart_dummy_3) }
        buttonIlmuBudaya.setOnClickListener { changeChartImage(R.drawable.chart_dummy_4) }
    }

    private fun changeChartImage(drawableResId: Int) {
        chartImageView.setImageResource(drawableResId)
    }
}