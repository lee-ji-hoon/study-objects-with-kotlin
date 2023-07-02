package hoondong.chapter11

import java.time.Duration

class NightlyDiscountPolicy(
        private val nightlyAmount: Money,
        private val regularAmount: Money,
        private val seconds: Duration
) : BasicRatePolicy() {
    override fun calculateCallFee(call: Call): Money {
        return if (call.from.hour >= LateNightHour) {
            nightlyAmount * (call.duration.seconds / seconds.seconds)
        } else {
            regularAmount * (call.duration.seconds / seconds.seconds)
        }
    }

    companion object {
        private const val LateNightHour: Int = 22
    }
}

