package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.view.LayoutInflater
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var chartImageView: ImageView
    private lateinit var buttonsContainer: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chartImageView = findViewById(R.id.chartImageView)
        buttonsContainer = findViewById(R.id.buttonsContainer)

        val faculties = arrayOf(
            Triple("Fakultas", "Teknik", R.drawable.chart_dummy_1),
            Triple("Fakultas", "Pertanian", R.drawable.chart_dummy_2),
            Triple("Fakultas", "MIPA", R.drawable.chart_dummy_3),
            Triple("Fakultas", "Kedokteran", R.drawable.chart_dummy_4),
            Triple("Fakultas", "Ilmu Pendidikan", R.drawable.chart_dummy_1),
            Triple("Program", "Pasca Sarjana", R.drawable.chart_dummy_2),
            Triple("Fakultas", "Hukum", R.drawable.chart_dummy_3),
            Triple("Fakultas", "Ilmu Budaya", R.drawable.chart_dummy_4)
        )

        for ((index, faculty) in faculties.withIndex()) {
            val facultyLabel = faculty.first
            val departmentName = faculty.second
            val drawableResId = faculty.third

            val buttonLayout = createButtonLayout(facultyLabel, departmentName, drawableResId)

            val rowSpec = GridLayout.spec(index / 2, 1f)
            val colSpec = GridLayout.spec(index % 2, 1f)

            val layoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
            layoutParams.width = 0
            layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT
            layoutParams.setMargins(8, 8, 8, 8)
            buttonLayout.layoutParams = layoutParams

            buttonsContainer.addView(buttonLayout)
        }
    }

    private fun createButtonLayout(facultyLabel: String, departmentName: String, drawableResId: Int): View {
        val inflater = LayoutInflater.from(this)
        val cardView = inflater.inflate(R.layout.button_layout, buttonsContainer, false) as CardView

        val icon = cardView.findViewById<ImageView>(R.id.icon)
        val facultyName = cardView.findViewById<TextView>(R.id.facultyName)
        val department = cardView.findViewById<TextView>(R.id.departmentName)

        icon.setImageResource(R.drawable.ic_placeholder)
        facultyName.text = facultyLabel
        department.text = departmentName

        cardView.setOnClickListener {
            changeChartImage(drawableResId)
        }

        return cardView
    }

    private fun changeChartImage(drawableResId: Int) {
        chartImageView.setImageResource(drawableResId)
    }
}