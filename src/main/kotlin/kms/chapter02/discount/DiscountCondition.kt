package kms.chapter02.discount

import kms.chapter02.Screening

internal interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
