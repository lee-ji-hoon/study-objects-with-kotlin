package kms.chapter14

import kms.chapter14.Money
import kms.chapter14.Phone

interface RatePolicy {

    fun calculateFee(phone: Phone) : Money
}