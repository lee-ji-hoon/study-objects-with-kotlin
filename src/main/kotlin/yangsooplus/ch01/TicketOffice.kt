package yangsooplus.ch01

data class TicketOffice(
    var amount: Long,
    val tickets: MutableList<Ticket>
) {

    fun getTicket(): Ticket = tickets.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}