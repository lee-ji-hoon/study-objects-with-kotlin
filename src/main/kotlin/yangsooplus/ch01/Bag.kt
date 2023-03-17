package yangsooplus.ch01

data class Bag(
    var amount: Long,
    var invitation: Invitation?,
    var ticket: Ticket?
) {
    constructor(amount: Long): this(amount, null, null) {
        this.amount = amount
    }

    constructor(invitation: Invitation, ticket: Ticket): this(0L, invitation, ticket) {
        this.invitation = invitation
        this.ticket = ticket
    }

    fun hold(ticket: Ticket): Long {
        this.ticket = ticket
        return if (hasInvitation()) {
            0L
        } else {
            minusAmount(ticket.fee)
            ticket.fee
        }
    }

    private fun hasInvitation() = invitation != null

    fun hasTicket() = ticket != null


    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}