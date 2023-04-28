package yangsooplus.ch05

import yangsooplus.ch02.Money
import yangsooplus.ch04.MovieType
import yangsooplus.ch05.discountcondition.DiscountCondition
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double

) {

    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }

        return fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { it.isSatisfiedBy(screening) }
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieType) {
            MovieType.AMOUNT_DISCOUNT -> discountAmount
            MovieType.PERCENT_DISCOUNT -> fee.times(discountPercent)
            MovieType.NONE_DISCOUNT -> Money.ZERO
        }
    }
}