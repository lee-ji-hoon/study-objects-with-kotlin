package hoondong

class Bag(private var invitation: Invitation? = null) {
    var amount: Long = 0L
    private set
    private var ticket: Ticket? = null

    fun hasInvitation() = invitation != null

    fun hasTicket() = ticket != null

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}