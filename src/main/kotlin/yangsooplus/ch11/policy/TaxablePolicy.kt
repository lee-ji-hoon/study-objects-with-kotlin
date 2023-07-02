package yangsooplus.ch11.policy

import yangsooplus.ch02.Money
import yangsooplus.ch11.policy.AdditionalRatePolicy

class TaxablePolicy(
    private val taxRate: Double,
    private val next: AdditionalRatePolicy
) : AdditionalRatePolicy(next) {


    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate))
    }
}