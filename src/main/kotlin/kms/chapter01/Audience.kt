package kms.chapter01

internal class Audience(private val bag: Bag) {

    fun buy(ticket: Ticket): Long {
        return if (bag.hasInvitation()) {
            bag.setTicket(ticket)
            0L
        } else {
            bag.minusAmount(ticket.fee)
            ticket.fee
        }
    }
}
