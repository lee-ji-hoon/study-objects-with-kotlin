package hoondong.chapter02

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private var discountPolicy: DiscountPolicy
    ) {
    fun getFee(): Money {
        return fee
    }

    fun calculateMovieFee(screening: Screening): Money {
        if (discountPolicy is NoneDiscountPolicy) {
            return fee
        }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}