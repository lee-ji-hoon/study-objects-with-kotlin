package ezhoon.chapter02.policy

import ezhoon.chapter02.Money
import ezhoon.chapter02.Screening
import ezhoon.chapter02.condition.DiscountCondition

class NoneDiscountPolicy(
    override val conditions: List<DiscountCondition>
) : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        return getDiscountAmount(screening)
    }

    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}