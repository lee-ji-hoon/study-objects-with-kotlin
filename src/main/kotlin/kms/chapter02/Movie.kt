package kms.chapter02

import kms.chapter02.discount.DiscountPolicy
import java.time.Duration

internal class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private var discountPolicy: DiscountPolicy,
) {

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }

    fun calculateMovieFee(screening: Screening): Money {
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
