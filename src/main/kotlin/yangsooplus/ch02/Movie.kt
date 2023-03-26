package yangsooplus.ch02

import yangsooplus.ch02.policy.DiscountPolicy
import java.time.Duration

data class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    var discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money{
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}
