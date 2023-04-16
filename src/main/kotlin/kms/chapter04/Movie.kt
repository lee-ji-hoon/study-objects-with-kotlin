package kms.chapter04

import java.time.Duration
import java.time.LocalDateTime

data class Movie(
    val title: String,
    val runningTime: Duration,
    private val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double,
) {
    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return discountConditions.any { condition ->
            when (condition.type) {
                DiscountConditionType.PERIOD -> condition.isDiscountable(
                    whenScreened.dayOfWeek,
                    whenScreened.toLocalTime(),
                )

                DiscountConditionType.SEQUENCE -> condition.isDiscountable(sequence)
            }
        }
    }

    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee - discountAmount
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee - fee * discountPercent
    }

    fun calculateNoneDiscountedFee(): Money {
        return fee
    }
}
