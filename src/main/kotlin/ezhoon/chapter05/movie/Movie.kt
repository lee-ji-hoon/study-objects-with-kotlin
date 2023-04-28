package ezhoon.chapter05.movie

import ezhoon.chapter05.Money
import ezhoon.chapter05.discount.DiscountCondition
import java.time.Duration

data class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
) {
    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) fee.minus(calculateDiscountAmount()) else fee
    }

    private fun isDiscountable(screening: Screening): Boolean = discountConditions.any { it.isDiscountable(screening.sequence) }

    private fun calculateDiscountAmount(): Money {
        return when(movieType) {
            MovieType.AmountDiscount -> calculateAmountDiscountAmount()
            MovieType.PercentDiscount -> calculatePercentDiscountAmount()
            MovieType.NoneDiscount -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(): Money = discountAmount

    private fun calculatePercentDiscountAmount(): Money = fee.times(discountPercent)

    private fun calculateNoneDiscountAmount(): Money = Money.ZERO

}