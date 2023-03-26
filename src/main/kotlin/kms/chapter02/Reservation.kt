package kms.chapter02

internal class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int,
)
