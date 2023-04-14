package hoondong.chapter04

import java.time.LocalDateTime

class Screening(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when(movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                return movie.calculateAmountDiscountedFee().times(audienceCount)
            }
            MovieType.PERCENT_DISCOUNT -> {
                return movie.calculatePercentDiscountedFee().times(audienceCount)
            }
            MovieType.NONE_DISCOUNT -> {
                return movie.calculatedNoneDiscountedFee().times(audienceCount)
            }
        }
    }
}