package hoondong.chapter04

import hoondong.chapter04.Customer
import hoondong.chapter04.Reservation

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie
        var discountable = false

        movie.discountConditions.forEach { condition ->
            discountable = if (condition.type == DiscountConditionType.PERIOD) {
                screening.whenScreened.dayOfWeek == condition.dayOfWeek &&
                        condition.startTime <= screening.whenScreened.toLocalTime() &&
                        condition.endTime >= screening.whenScreened.toLocalTime()
            } else {
                condition.sequence == screening.sequence
            }

            if (discountable) {
                return@forEach
            }
        }

        val fee: Money
        if (discountable) {
            val discountAmount = when (movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> {
                    movie.discountAmount
                }

                MovieType.PERCENT_DISCOUNT -> {
                    movie.fee.times(movie.discountPercent)
                }

                MovieType.NONE_DISCOUNT -> {
                    Money.ZERO
                }
            }

            fee = movie.fee.minus(discountAmount)
        } else {
            fee = movie.fee
        }
        return Reservation(customer, screening, fee, audienceCount)
    }
}