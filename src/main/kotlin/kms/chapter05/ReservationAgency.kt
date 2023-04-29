package kms.chapter05

class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        return screening.reserve(customer, audienceCount)
    }
}
