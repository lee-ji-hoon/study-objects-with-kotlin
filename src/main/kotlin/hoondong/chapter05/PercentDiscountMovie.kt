package hoondong.chapter05

import kotlin.time.Duration

class PercentDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    private val percent: Double,
    discountConditions: List<DiscountCondition>
): Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return fee.times(percent)
    }
}