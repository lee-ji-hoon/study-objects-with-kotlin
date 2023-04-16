package ezhoon.chapter04

import ezhoon.chapter04.movie.Screening

class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
)