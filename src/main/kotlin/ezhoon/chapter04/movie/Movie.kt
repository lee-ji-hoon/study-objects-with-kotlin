package ezhoon.chapter04.movie

import ezhoon.chapter04.Money
import ezhoon.chapter04.discount.DiscountCondition
import ezhoon.chapter04.discount.DiscountConditionType
import java.time.Duration
import java.time.LocalDateTime

data class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
) {
    /**
     * Movie가 어떤 데이터를 포함해야 하는가?
     *
     * 영화 요금 계산, 할인 여부 판단? discountConditions가 존재하니까?
     */

    fun calculateAmountDiscountedFee(): Money {
        require(movieType is MovieType.AmountDiscount)
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        require(movieType is MovieType.PercentDiscount)
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        require(movieType is MovieType.NoneDiscount)
        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return discountConditions.any { it.isDiscountable(whenScreened, sequence) }
    }

    private fun DiscountCondition.isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return when (type) {
            DiscountConditionType.Period -> isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())
            DiscountConditionType.Sequence -> isDiscountable(sequence)
        }
    }
}