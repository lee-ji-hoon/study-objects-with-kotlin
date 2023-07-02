package yangsooplus.ch11.policy

import yangsooplus.ch02.Money
import yangsooplus.ch11.policy.AdditionalRatePolicy

class RateDiscountablePolicy(
    private val discountAmount: Money,
    private val next: AdditionalRatePolicy
): AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}
