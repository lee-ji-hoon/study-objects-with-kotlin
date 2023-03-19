package hoondong

class TicketOffice(private var amount: Long, vararg tickets: Ticket) {
    private val tickets: MutableList<Ticket> = mutableListOf()

    init {
        this.tickets.addAll(tickets)
    }

    private fun getTicket() = tickets.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun sellTicketTo(audience: Audience) {
        val ticket: Ticket = getTicket()
        val fee = audience.buy(ticket)
        plusAmount(fee)
    }
}