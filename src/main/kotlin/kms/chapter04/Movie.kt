package kms.chapter04

data class Movie(
    val movieType: MovieType,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val discountAmount: Money,
    val discountPercent: Double,
)
