package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.DiscountCondition

interface DiscountPolicy{
    fun calculateDiscountAmount(screening: Screening): Money
}
