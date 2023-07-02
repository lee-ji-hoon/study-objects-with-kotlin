package yangsooplus.ch11.policy

import yangsooplus.ch02.Money
import yangsooplus.ch11.Phone

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}