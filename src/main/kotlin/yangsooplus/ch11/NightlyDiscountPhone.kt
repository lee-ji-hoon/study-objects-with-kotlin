package yangsooplus.ch11

import yangsooplus.ch02.Money
import java.time.Duration

open class NightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration
) : Phone() {


    override fun calculateCallFee(call: Call): Money {
        val amount = if (call.from.hour >= LATE_NIGHT_HOUR) nightlyAmount else regularAmount
        return amount.times((call.duration.seconds / seconds.seconds).toDouble())
    }




    companion object {
        private const val LATE_NIGHT_HOUR = 22
    }
}