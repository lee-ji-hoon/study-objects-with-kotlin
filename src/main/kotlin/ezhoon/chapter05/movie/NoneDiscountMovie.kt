package ezhoon.chapter05.movie

import ezhoon.chapter05.Money
import ezhoon.chapter05.discount.DiscountCondition
import java.time.Duration

class NoneDiscountMovie(
    override val title: String,
    override val runningTime: Duration,
    override val fee: Money,
    override val discountConditions: List<DiscountCondition>
) : Movie {

    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}