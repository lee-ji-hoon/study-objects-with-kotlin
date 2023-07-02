package yangsooplus.ch11

import yangsooplus.ch02.Money
import java.time.Duration

class TaxableNightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration,
    private val taxRate: Double
): NightlyDiscountPhone(nightlyAmount, regularAmount, seconds) {

    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate))
    }
}