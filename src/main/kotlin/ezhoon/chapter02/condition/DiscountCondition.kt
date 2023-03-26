package ezhoon.chapter02.condition

import ezhoon.chapter02.Screening

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
