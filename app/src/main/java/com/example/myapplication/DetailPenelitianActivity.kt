package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPenelitianActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penelitian)

        val facultyName = intent.getStringExtra("EXTRA_FACULTY_NAME") ?: "Nama Fakultas"
        val year = intent.getStringExtra("EXTRA_YEAR") ?: "Tahun Penelitian"

        val facultyTextView = findViewById<TextView>(R.id.facultyNameTextView)
        val yearTextView = findViewById<TextView>(R.id.yearTextView)
        val tableLayout = findViewById<TableLayout>(R.id.detailTableLayout)

        facultyTextView.text = facultyName
        yearTextView.text = year

        val data = listOf(
            Pair("Fulan", "Penelitian A"),
            Pair("Fulano", "Penelitian B"),
            Pair("Fulana", "Penelitian C"),
            Pair("Fulanita", "Penelitian D"),
            Pair("Fulawarman", "Penelitian E")
        )

        for (entry in data) {
            val tableRow = TableRow(this)

            val textViewNama = TextView(this).apply {
                text = entry.first
                setPadding(8, 8, 8, 8)
                gravity = Gravity.CENTER
                setTextColor(resources.getColor(android.R.color.black))
            }

            val textViewJudul = TextView(this).apply {
                text = entry.second
                setPadding(8, 8, 8, 8)
                gravity = Gravity.CENTER
                setTextColor(resources.getColor(android.R.color.black))
            }

            tableRow.addView(textViewNama)
            tableRow.addView(textViewJudul)

            tableLayout.addView(tableRow)

            val separator = View(this).apply {
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1)
                setBackgroundColor(resources.getColor(R.color.black))
            }
            tableLayout.addView(separator)
        }
    }
}