package yangsooplus.ch04

import yangsooplus.ch02.Money
import java.time.Duration
import java.time.LocalDateTime

class Movie(
    val title: String,
    val runningTime: Duration,
    private val fee: Money,
    val discountConditions: List<DiscountCondition>,

    val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
) {
    fun calculateAmountDiscountedFee(): Money {
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money = fee

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        discountConditions.forEach { condition ->
            when (condition.type) {
                DiscountConditionType.PERIOD -> {
                    if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime()))
                        return true
                }

                DiscountConditionType.SEQUENCE -> {
                    if (condition.isDiscountable(sequence))
                        return true
                }
            }
        }
        return false
    }

}

enum class MovieType {
    AMOUNT_DISCOUNT, PERCENT_DISCOUNT, NONE_DISCOUNT
}