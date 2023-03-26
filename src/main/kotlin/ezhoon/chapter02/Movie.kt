package ezhoon.chapter02

import ezhoon.chapter02.policy.DiscountPolicy
import ezhoon.chapter02.policy.NoneDiscountPolicy
import java.time.Duration

data class Movie(
    private val fee: Money,
    private val runningTime: Duration,
    private val title: String,
    private var discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun getFee() = fee

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}
