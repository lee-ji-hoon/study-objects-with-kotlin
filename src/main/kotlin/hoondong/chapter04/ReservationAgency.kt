package hoondong.chapter04

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val fee: Money = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}