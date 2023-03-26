package hoondong.chapter02.condition

import hoondong.chapter02.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}