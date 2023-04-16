package kms.chapter04

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime,
) {

    fun calculateFee(audienceCount: Int): Money {
        return if (movie.isDiscountable(whenScreened, sequence)) {
            when (movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> movie.calculateAmountDiscountedFee()
                MovieType.PERCENT_DISCOUNT -> movie.calculatePercentDiscountedFee()
                MovieType.NONE_DISCOUNT -> movie.calculateNoneDiscountedFee()
            }
        } else {
            movie.calculateNoneDiscountedFee()
        } * audienceCount
    }
}
