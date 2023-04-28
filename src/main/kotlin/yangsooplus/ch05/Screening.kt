package yangsooplus.ch05

import yangsooplus.ch02.Money
import yangsooplus.ch04.Reservation
import yangsooplus.ch04.Customer
import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime

) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}
