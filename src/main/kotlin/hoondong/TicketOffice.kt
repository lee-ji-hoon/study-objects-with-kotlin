package hoondong

class TicketOffice(private var amount: Long, vararg tickets: Ticket) {
    private val tickets: MutableList<Ticket> = mutableListOf()

    init {
        this.tickets.addAll(tickets)
    }

    /**
     * 문제점
     * 1. 누구든 티켓에 접근할 수 있다.
     */
    fun getTicket() = tickets.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}