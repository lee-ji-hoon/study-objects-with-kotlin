package ezhoon.chapter04.movie

import ezhoon.chapter04.Money
import java.time.LocalDateTime

class Screening(
    val movie: Movie,
    val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        val fee = when {
            movie.isDiscountable(whenScreened, sequence) -> when (movie.movieType) {
                MovieType.AmountDiscount -> movie.calculateAmountDiscountedFee()
                MovieType.PercentDiscount -> movie.calculatePercentDiscountedFee()
                MovieType.NoneDiscount-> movie.calculateNoneDiscountedFee()
            }
            else -> movie.calculateNoneDiscountedFee()
        }
        return fee * audienceCount.toDouble()
    }
}