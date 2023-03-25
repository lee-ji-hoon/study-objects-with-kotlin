package hoondong.chapter02.policy

import hoondong.chapter02.condition.DiscountCondition
import hoondong.chapter02.Money
import hoondong.chapter02.Screening

abstract class DefaultDiscountPolicy(
    vararg tempConditions: DiscountCondition
): DiscountPolicy {
    private val conditions: List<DiscountCondition> = listOf(*tempConditions)

    override fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach { each ->
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}