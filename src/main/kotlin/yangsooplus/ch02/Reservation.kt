package yangsooplus.ch02

data class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
)
