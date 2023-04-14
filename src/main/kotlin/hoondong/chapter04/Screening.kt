package hoondong.chapter04

import java.time.LocalDateTime

class Screening(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        return when(movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                movie.calculateAmountDiscountedFee().times(audienceCount)
            }

            MovieType.PERCENT_DISCOUNT -> {
                movie.calculatePercentDiscountedFee().times(audienceCount)
            }

            MovieType.NONE_DISCOUNT -> {
                movie.calculatedNoneDiscountedFee().times(audienceCount)
            }
        }
    }
}