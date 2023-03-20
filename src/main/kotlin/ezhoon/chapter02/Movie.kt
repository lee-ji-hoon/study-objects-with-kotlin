package ezhoon.chapter02

import java.math.BigDecimal

data class Movie(
    val fee: Int
) {
    fun calculateMovieFee(screening: Screening): Money {
        return Money(BigDecimal(10).plus(BigDecimal(screening.getMovieFee())))
    }
}
