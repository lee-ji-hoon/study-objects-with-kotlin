package ezhoon.chapter05.movie

import ezhoon.chapter05.Money
import ezhoon.chapter05.discount.DiscountCondition
import java.time.Duration

interface Movie{

    val title: String
    val runningTime: Duration
    val fee: Money
    val discountConditions: List<DiscountCondition>

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) fee.minus(calculateDiscountAmount()) else fee
    }

    private fun isDiscountable(screening: Screening): Boolean = discountConditions.any { it.isDisCountable(screening) }

    fun calculateDiscountAmount(): Money
}