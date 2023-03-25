package yangsooplus.ch02.condition

import yangsooplus.ch02.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
