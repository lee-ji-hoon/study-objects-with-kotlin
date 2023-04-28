package yangsooplus.ch05.movie

import yangsooplus.ch02.Money
import yangsooplus.ch05.Screening
import yangsooplus.ch05.discountcondition.DiscountCondition
import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
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

    protected abstract fun calculateDiscountAmount(): Money
}