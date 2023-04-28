package hoondong.chapter05

import kotlin.time.Duration

class NoneDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    discountConditions: List<DiscountCondition>
): Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}