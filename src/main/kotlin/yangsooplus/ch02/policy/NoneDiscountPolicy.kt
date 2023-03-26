package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening

class NoneDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}