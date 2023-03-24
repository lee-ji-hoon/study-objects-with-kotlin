package yangsooplus.ch02

import java.time.Duration

data class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money{
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }
}
