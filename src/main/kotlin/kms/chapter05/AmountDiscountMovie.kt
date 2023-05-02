package kms.chapter05

import java.time.Duration

class AmountDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    discountConditions: List<DiscountCondition>,
    private val discountAmount: Money
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}