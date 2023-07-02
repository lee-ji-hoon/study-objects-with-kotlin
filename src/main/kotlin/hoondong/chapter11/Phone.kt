package hoondong.chapter11

import java.time.Duration

class Phone(
        private val amount: Money,
        private val seconds: Duration,
        private val taxRate: Double
) {
    private val calls: MutableList<Call> = mutableListOf()

    fun call(call: Call) {
        calls.add(call)
    }

    fun getCalls(): List<Call> {
        return calls
    }

    fun calculateFee(): Money {
        var result: Money = Money.ZERO
        for (call in calls) {
            result += amount * (call.duration.seconds / seconds.seconds)
        }
        return result + result * taxRate
    }
}