package com.example.creating_a_spinner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivityViewModel:ViewModel() {
    var solution: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getSolution(sideA: Double, sideB: Double, sideC: Double, solutionName: String) {
        val intSideA: Int = roundOffDecimal(sideA)
        val intSideB: Int = roundOffDecimal(sideB)
        val intSideC: Int = roundOffDecimal(sideC)
        when (solutionName) {
            "Сумма длины ребер" -> solution.value = intSideA * 4 + intSideB * 4 + intSideC * 4
            "Площадь поверхности" -> solution.value = 2 * (intSideA * intSideB +
                    intSideB * intSideC +
                    intSideA * intSideC)
            else -> solution.value = intSideA * intSideB * intSideC
        }
    }

    private fun roundOffDecimal(number: Double): Int {
        val df = DecimalFormat("#")
        df.roundingMode = RoundingMode.HALF_UP
        return df.format(number).toInt()
    }
}