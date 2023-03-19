package kms.chapter01

import kotlin.collections.ArrayList

internal class TicketOffice constructor(
    private var amount: Long = 0L,
    private val tickets: MutableList<Ticket> = ArrayList(),
) {
    constructor(amount: Long, vararg tickets: Ticket) : this(
        amount,
        ArrayList<Ticket>().apply {
            addAll(tickets.toList())
        },
    )

    fun getTicket(): Ticket? {
        return if (tickets.isNotEmpty()) {
            tickets.removeAt(0)
        } else {
            null
        }
    }

    fun minusAmount(amount: Long) {
        this.amount = this.amount - amount
    }

    fun plusAmount(amount: Long) {
        this.amount = this.amount + amount
    }
}
