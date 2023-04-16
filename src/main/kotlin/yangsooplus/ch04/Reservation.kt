package yangsooplus.ch04

import yangsooplus.ch02.Money

class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
)
