package yangsooplus.ch04

import yangsooplus.ch02.Money
import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {

    fun calculateFee(audienceCnt: Int): Money {
        return when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> movie.calculateAmountDiscountedFee()
            MovieType.PERCENT_DISCOUNT -> movie.calculatePercentDiscountedFee()
            MovieType.NONE_DISCOUNT -> movie.calculateNoneDiscountedFee()
        }.times(audienceCnt)
    }

}
