package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.DiscountCondition

abstract class DiscountPolicy(
    private val conditions: List<DiscountCondition>
) {

    fun calculateDiscountAmount(screening: Screening): Money {
        if (conditions.isEmpty()) return Money.ZERO

        for (c in conditions) {
            if (c.isSatisfiedBy(screening).not()) return Money.ZERO
        }

        return getDiscountAmount(screening)
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
