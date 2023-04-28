package ezhoon.chapter05.movie

import ezhoon.chapter05.Customer
import ezhoon.chapter05.Reservation
import java.time.LocalDateTime

class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun reserve(
        customer: Customer,
        audienceCount: Int
    ) = Reservation(
        customer = customer,
        screening = this,
        fee = calculateFee(audienceCount),
        audienceCount = audienceCount
    )

    fun calculateFee(audienceCount: Int) = movie.calculateMovieFee(this).times(audienceCount)
}