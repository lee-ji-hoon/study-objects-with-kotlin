package hoondong.chapter11

import java.time.Duration

class RegularPolicy(private val amount: Money, private val seconds: Duration): BasicRatePolicy() {
    override fun calculateCallFee(call: Call): Money {
        return amount * (call.duration.seconds / seconds.seconds)
    }

}