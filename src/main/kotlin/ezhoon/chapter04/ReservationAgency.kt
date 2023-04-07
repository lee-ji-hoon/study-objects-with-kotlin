package ezhoon.chapter04

import ezhoon.chapter04.discount.DiscountCondition
import ezhoon.chapter04.discount.DiscountConditionType
import ezhoon.chapter04.movie.MovieType
import ezhoon.chapter04.movie.Screening

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int
    ): Reservation {

        val movie = screening.movie

        val discountable = movie.discountConditions.any { discountCondition ->
            when (discountCondition.type) {
                is DiscountConditionType.Period -> {
                    isSameDayOfWeek(screening, discountCondition) && isAfterOrEqualStartTime(discountCondition, screening) && isBeforeOrEqualEndTime(discountCondition, screening)
                }
                is DiscountConditionType.Sequence -> {
                    isSameSequence(discountCondition, screening)
                }
            }
        }

        val fee = if (discountable) {
            val discountAmount = when (movie.movieType) {
                is MovieType.AmountDiscount -> movie.discountAmount
                is MovieType.NoneDiscount -> movie.fee.times(movie.discountPercent)
                is MovieType.PercentDiscount -> Money.ZERO
            }
            movie.fee.minus(discountAmount)
        } else {
            movie.fee
        }

        return Reservation(customer, screening, fee, audienceCount)
    }

    private fun isBeforeOrEqualEndTime(
        discountCondition: DiscountCondition,
        screening: Screening
    ): Boolean = discountCondition.endTime >= screening.whenScreened.toLocalTime()

    private fun isAfterOrEqualStartTime(
        discountCondition: DiscountCondition,
        screening: Screening
    ): Boolean = discountCondition.startTime <= screening.whenScreened.toLocalTime()

    private fun isSameDayOfWeek(
        screening: Screening,
        discountCondition: DiscountCondition
    ): Boolean = screening.whenScreened.dayOfWeek == discountCondition.dayOfWeek

    private fun isSameSequence(
        discountCondition: DiscountCondition,
        screening: Screening
    ): Boolean = discountCondition.sequence == screening.sequence
}