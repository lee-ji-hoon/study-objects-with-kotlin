package hoondong.chapter02.policy

import hoondong.chapter02.Money
import hoondong.chapter02.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}