package kms.chapter01

internal class Bag(
    private var amount: Long = 0,
    private val invitation: Invitation? = null,
    private var ticket: Ticket? = null,
) {
    fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun setTicket(ticket: Ticket?) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount = this.amount - amount
    }

    fun plusAmount(amount: Long) {
        this.amount = this.amount + amount
    }
}
