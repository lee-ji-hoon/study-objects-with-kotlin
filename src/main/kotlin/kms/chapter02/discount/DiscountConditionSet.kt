package kms.chapter02.discount

import kms.chapter02.Screening

internal class DiscountConditionSet(
    private val conditions: List<DiscountCondition>,
) : DiscountCondition {

    constructor(vararg conditions: DiscountCondition) : this(conditions.toList())

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return conditions.all { it.isSatisfiedBy(screening) }
    }
}
