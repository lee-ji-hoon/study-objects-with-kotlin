package hoondong.chapter05

import java.lang.IllegalStateException
import kotlin.time.Duration

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
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(): Money {
        return discountAmount
    }

    private fun calculatePercentDiscountAmount(): Money {
        return fee.times(discountPercent)
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }
}