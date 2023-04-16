package ezhoon.chapter04.discount

sealed interface DiscountConditionType {

    object Sequence : DiscountConditionType
    object Period : DiscountConditionType
}