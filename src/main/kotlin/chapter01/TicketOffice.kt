package chapter01

/**
 * 티켓 판매
 *
 * @property amount : 가격
 * @property tickets : 티켓들
 */
data class TicketOffice(
    private var amount: Long,
    private var tickets: MutableList<Ticket> = mutableListOf()
) {

    fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}