package yangsooplus.ch04

import yangsooplus.ch02.Money

class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCnt: Int): Reservation {
        val movie = screening.movie

        var discountable = false
        movie.discountConditions.forEach { condition ->
            discountable = when (condition.type) {
                DiscountConditionType.PERIOD -> {
                    screening.whenScreened.dayOfWeek == condition.dayOfWeek &&
                            condition.startTime <= screening.whenScreened.toLocalTime() &&
                            condition.endTime >= screening.whenScreened.toLocalTime()
                }
                DiscountConditionType.SEQUENCE -> {
                    condition.sequence == screening.sequence
                }
            }

            if (discountable) return@forEach
        }

        val fee = if (discountable) {
            val discountAmount = when(movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
                MovieType.PERCENT_DISCOUNT -> movie.fee.times(movie.discountPercent)
                MovieType.NONE_DISCOUNT -> Money.ZERO
            }
            movie.fee.minus(discountAmount)
        } else {
            movie.fee
        }

        return Reservation(customer, screening, fee, audienceCnt)
    }
}