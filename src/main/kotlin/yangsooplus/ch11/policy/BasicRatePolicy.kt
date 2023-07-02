package yangsooplus.ch11.policy

import yangsooplus.ch02.Money
import yangsooplus.ch11.Call
import yangsooplus.ch11.Phone

abstract class BasicRatePolicy : RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        var result = Money.ZERO
        phone.calls.forEach {
            result = result.plus(calculateCallFee(it))
        }
        return result
    }

    protected abstract fun calculateCallFee(call: Call): Money
}