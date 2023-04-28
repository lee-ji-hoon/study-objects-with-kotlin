package yangsooplus.ch05.movie

import yangsooplus.ch02.Money
import yangsooplus.ch05.discountcondition.DiscountCondition
import java.time.Duration

class PercentDiscountMovie(
    private val discountPercent: Double,
    title: String,
    runningTime: Duration,
    private val fee: Money,
    discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return fee.times(discountPercent)
    }
}