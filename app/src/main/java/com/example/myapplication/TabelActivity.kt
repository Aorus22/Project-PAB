package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class TabelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabel)

        val facultyName = intent.getStringExtra("EXTRA_FACULTY_NAME") ?: "Nama Fakultas"
        val facultyTextView = findViewById<TextView>(R.id.facultyNameTextView)
        facultyTextView.text = facultyName

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val barChart = findViewById<BarChart>(R.id.barChart)

        val data = listOf(
            Pair("2018", "10"),
            Pair("2019", "15"),
            Pair("2020", "12"),
            Pair("2021", "20"),
            Pair("2022", "18"),
            Pair("2023", "25")
        )

        val entries = ArrayList<BarEntry>()
        val labels = ArrayList<String>()

        for ((index, entry) in data.withIndex()) {
            val tableRow = TableRow(this)

            val textViewTahun = TextView(this).apply {
                text = entry.first
                setPadding(8, 8, 8, 8)
                gravity = Gravity.CENTER
                setTextColor(resources.getColor(android.R.color.black))
            }

            val textViewJumlah = TextView(this).apply {
                text = entry.second
                setPadding(8, 8, 8, 8)
                gravity = Gravity.CENTER
                setTextColor(resources.getColor(android.R.color.black))
            }

            val buttonDetail = Button(this).apply {
                text = "Detail"
                setPadding(8, 8, 8, 8)
                gravity = Gravity.CENTER
                setOnClickListener {
                    val intent = Intent(this@TabelActivity, DetailPenelitianActivity::class.java).apply {
                        putExtra("EXTRA_FACULTY_NAME", facultyName)
                        putExtra("EXTRA_YEAR", entry.first)
                    }
                    startActivity(intent)
                }
            }

            tableRow.addView(textViewTahun)
            tableRow.addView(textViewJumlah)
            tableRow.addView(buttonDetail)

            tableLayout.addView(tableRow)

            val separator = View(this).apply {
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1)
                setBackgroundColor(resources.getColor(R.color.black))
            }
            tableLayout.addView(separator)

            entries.add(BarEntry(index.toFloat(), entry.second.toFloat()))
            labels.add(entry.first)
        }

        val dataSet = BarDataSet(entries, "Jumlah Penelitian")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        val barData = BarData(dataSet)

        barChart.data = barData
        barChart.animateY(1000)
        barChart.setFitBars(true)
        barChart.description.isEnabled = false
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        barChart.invalidate()
    }
}