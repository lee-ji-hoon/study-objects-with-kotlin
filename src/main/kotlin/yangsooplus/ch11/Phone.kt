package yangsooplus.ch11

import yangsooplus.ch02.Money

abstract class Phone {
    private val calls: List<Call> = emptyList()

    fun calculateFee(): Money {
        var result = Money.ZERO
        calls.forEach {
            result = result.plus(calculateCallFee(it))
        }
        return result
    }

    protected abstract fun calculateCallFee(call: Call): Money
}