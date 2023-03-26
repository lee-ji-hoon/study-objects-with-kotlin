package kms.chapter02.discount

import kms.chapter02.Money
import kms.chapter02.Screening

internal class NoneDiscountPolicy : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money = Money.ZERO
}
