package ezhoon.chapter05.discount

sealed interface DiscountConditionType {

    object Sequence : DiscountConditionType
    object Period : DiscountConditionType
}