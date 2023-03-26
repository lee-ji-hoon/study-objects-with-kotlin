package ezhoon.chapter02.policy

import ezhoon.chapter02.Money
import ezhoon.chapter02.Screening
import ezhoon.chapter02.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    override val conditions: ArrayList<DiscountCondition>
) : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }

        }
        return Money.ZERO
    }

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}