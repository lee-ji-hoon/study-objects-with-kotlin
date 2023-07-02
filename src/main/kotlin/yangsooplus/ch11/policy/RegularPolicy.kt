package yangsooplus.ch11.policy

import yangsooplus.ch02.Money
import yangsooplus.ch11.Call
import java.time.Duration

open class RegularPolicy(
    private val amount: Money,
    private val seconds: Duration
) : BasicRatePolicy() {


    override fun calculateCallFee(call: Call): Money {
        return amount.times((call.duration.seconds / seconds.seconds).toDouble())
    }

}