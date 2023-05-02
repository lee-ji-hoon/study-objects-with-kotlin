package yangsooplus.ch04

import yangsooplus.ch02.Money
import yangsooplus.ch05.Screening

class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
)
