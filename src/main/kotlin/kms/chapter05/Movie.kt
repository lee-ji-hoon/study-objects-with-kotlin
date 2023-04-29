package kms.chapter05

import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    protected val fee: Money,
    private val discountConditions: List<DiscountCondition>,
) {

    fun calculateFee(screening: Screening): Money {
        return if (isDiscountable(screening)) {
            fee - calculateDiscountAmount()
        } else {
            fee
        }
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.stream()
            .anyMatch { condition ->
                condition.isSatisfiedBy(screening)
            }
    }

    protected abstract fun calculateDiscountAmount(): Money
}
