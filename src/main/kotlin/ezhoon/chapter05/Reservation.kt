package ezhoon.chapter05

import ezhoon.chapter05.movie.Screening

class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
)