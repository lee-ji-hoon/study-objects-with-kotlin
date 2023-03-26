package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.DiscountCondition

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>
) : DiscountPolicy {


    override fun calculateDiscountAmount(screening: Screening): Money {
        if (conditions.isEmpty()) return Money.ZERO

        for (c in conditions) {
            if (c.isSatisfiedBy(screening)) return getDiscountAmount(screening)
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money

}