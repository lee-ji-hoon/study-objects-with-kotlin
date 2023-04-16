package kms.chapter04

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int,
    ): Reservation {
        return Reservation(
            customer,
            screening,
            screening.calculateFee(audienceCount),
            audienceCount,
        )
    }
}
