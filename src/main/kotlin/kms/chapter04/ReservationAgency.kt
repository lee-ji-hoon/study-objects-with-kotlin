package kms.chapter04

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int,
    ): Reservation {
        val movie = screening.movie
        val discountable = movie.discountConditions.any {
            it.isDiscountable(screening)
        }
        val fee = if (discountable) {
            val discountAmount = when (movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
                MovieType.PERCENT_DISCOUNT -> movie.fee * movie.discountPercent
                MovieType.NONE_DISCOUNT -> Money.ZERO
            }
            movie.fee - discountAmount
        } else {
            movie.fee
        }
        return Reservation(customer, screening, fee, audienceCount)
    }
}
