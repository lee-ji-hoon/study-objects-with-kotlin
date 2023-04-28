package yangsooplus.ch05.discountcondition

import yangsooplus.ch05.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}