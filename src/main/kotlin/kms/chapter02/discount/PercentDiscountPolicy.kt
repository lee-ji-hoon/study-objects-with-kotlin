package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>,
) : DefaultDiscountPolicy(conditions) {

    constructor(percent: Double, vararg conditions: DiscountCondition) : this(percent, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.fee * percent
    }
}
