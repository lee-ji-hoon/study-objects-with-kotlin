package hoondong.chapter04

import java.time.LocalDateTime
import kotlin.time.Duration

/**
 * 1. 어떤 데이터를 포함해야 하는가?
 * - 영화 제목, 상영 시간, 요금, 할인 조건
 * - 영화 종류, 할인양, 할인율
 *
 * 2. 어떤 연산을 수행해야 하는가?
 * - 요금 계산, 할인 여부 판단
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    var fee: Money,
    var discountConditions: List<DiscountCondition>,
    var movieType: MovieType,
    var discountAmount: Money,
    var discountPercent: Double
) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(fee.times(discountPercent))
    }

    fun calculatedNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return discountConditions.any {
            it.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())
        } || discountConditions.any { it.isDiscountable(sequence) }
    }
}