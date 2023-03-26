package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal interface DiscountPolicy {

    fun calculateDiscountAmount(screening: Screening): Money
}
