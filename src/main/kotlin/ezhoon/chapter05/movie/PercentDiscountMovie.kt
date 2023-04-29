package ezhoon.chapter05.movie

import ezhoon.chapter05.Money
import ezhoon.chapter05.discount.DiscountCondition
import java.time.Duration

class PercentDiscountMovie(
    override val title: String,
    override val runningTime: Duration,
    override val fee: Money,
    override val discountConditions: List<DiscountCondition>,
    private val percent: Double
): Movie {

    override fun calculateDiscountAmount(): Money {
        return fee.times(percent.toInt())
    }
}