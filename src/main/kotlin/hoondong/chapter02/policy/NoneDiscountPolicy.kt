package hoondong.chapter02.policy

import hoondong.chapter02.Money
import hoondong.chapter02.Screening

class NoneDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}