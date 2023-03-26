package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>,
) : DefaultDiscountPolicy(conditions) {

    constructor(discountAmount: Money, vararg conditions: DiscountCondition) : this(discountAmount, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}
