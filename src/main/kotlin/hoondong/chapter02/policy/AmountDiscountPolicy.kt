package hoondong.chapter02.policy

import hoondong.chapter02.condition.DiscountCondition
import hoondong.chapter02.Money
import hoondong.chapter02.Screening

class AmountDiscountPolicy(
    private val discountAmount: Money,
    vararg conditions: DiscountCondition
) : DefaultDiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}