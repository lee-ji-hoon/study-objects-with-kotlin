package yangsooplus.ch11

import yangsooplus.ch02.Money
import yangsooplus.ch11.policy.RatePolicy

abstract class Phone(private val ratePolicy: RatePolicy) {
    val calls: List<Call> = emptyList()

    fun calculateFee(): Money {
        return ratePolicy.calculateFee(this)
    }

}