package hoondong.chapter05

import kotlin.time.Duration

class AmountDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    private val discountAmount: Money,
    discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}