package ezhoon.chapter02

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
