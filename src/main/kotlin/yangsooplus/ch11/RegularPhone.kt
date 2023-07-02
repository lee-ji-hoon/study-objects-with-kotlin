package yangsooplus.ch11

import yangsooplus.ch02.Money
import java.time.Duration

open class RegularPhone(
    private val amount: Money,
    private val seconds: Duration
) : Phone() {


    override fun calculateCallFee(call: Call): Money {
        return amount.times((call.duration.seconds / seconds.seconds).toDouble())
    }

}