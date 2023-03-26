package ezhoon.chapter02

import java.math.BigDecimal
import java.time.Duration

data class Movie(
    private val fee: Money,
    private val runningTime: Duration,
    private val title: String,
    private val discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun getFee() = fee
}
