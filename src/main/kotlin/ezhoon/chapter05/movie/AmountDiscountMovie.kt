package ezhoon.chapter05.movie

import ezhoon.chapter05.Money
import ezhoon.chapter05.discount.DiscountCondition
import java.time.Duration

class AmountDiscountMovie(
    override val title: String,
    override val runningTime: Duration,
    override val fee: Money,
    override val discountConditions: List<DiscountCondition>,
    private val discountAmount: Money
): Movie {
    override fun calculateDiscountAmount(): Money = discountAmount
}