package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    private val conditions: List<DiscountCondition>
): DiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}
