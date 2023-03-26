package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>,
) : DiscountPolicy {

    constructor(vararg conditions: DiscountCondition) : this(conditions.toList())

    override fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
