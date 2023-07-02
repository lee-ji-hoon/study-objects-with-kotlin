package yangsooplus.ch11

import yangsooplus.ch02.Money
import java.time.Duration

class TaxableRegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    private val taxRate: Double
) : RegularPhone(amount, seconds) {


    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate))
    }
}