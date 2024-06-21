package com.example.myapplication

import com.github.mikephil.charting.formatter.ValueFormatter

class IndexAxisValueFormatter(private val labels: List<String>) : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return if (value.toInt() >= 0 && value.toInt() < labels.size) {
            labels[value.toInt()]
        } else {
            ""
        }
    }
}
