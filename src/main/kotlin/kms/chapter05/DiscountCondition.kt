package kms.chapter05

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
