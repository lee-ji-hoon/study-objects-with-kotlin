package yangsooplus.ch04



class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCnt: Int): Reservation {
        return Reservation(customer, screening, screening.calculateFee(audienceCnt), audienceCnt)
    }
}