package ezhoon.chapter05

import ezhoon.chapter05.movie.Screening

class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation? {
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}