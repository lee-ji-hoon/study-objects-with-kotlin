package hoondong.chapter01

class Bag(private var invitation: Invitation? = null) {
    var amount: Long = 0L
    private set
    private var ticket: Ticket? = null

    private fun hasInvitation() = invitation != null

    fun hasTicket() = ticket != null

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun hold(ticket: Ticket): Long {
        return if (hasInvitation()) {
            setTicket(ticket)
            0L
        } else {
            minusAmount(ticket.fee)
            setTicket(ticket)
            ticket.fee
        }
    }
}