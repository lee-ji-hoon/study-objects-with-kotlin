package yangsooplus.ch02

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {

    fun isSequence(sequence: Int) : Boolean = this.sequence == sequence

    fun getMovieFee(): Money = movie.fee

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}
