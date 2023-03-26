package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal class DiscountPolicySet(
    private val policies: List<DiscountPolicy>,
) : DiscountPolicy {

    constructor(vararg policies: DiscountPolicy) : this(policies.toList())

    override fun calculateDiscountAmount(screening: Screening): Money {
        var best = Money.ZERO
        for (policy in policies) {
            val cur = policy.calculateDiscountAmount(screening)
            if (cur > best) {
                best = cur
            }
        }
        return best
    }
}
