package kms.chapter05

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime,
) {

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateFee(this) * audienceCount
    }
}
