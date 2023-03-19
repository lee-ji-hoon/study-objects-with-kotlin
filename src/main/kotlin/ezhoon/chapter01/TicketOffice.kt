package ezhoon.chapter01

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

    /**
     * TODO TickOffice가 본인의 역할을 하는 것은 좋지만 audience와 결합이 됐다.
     * TickOffice가 본인의 책임을 다 할 수 있게 변경이 됐다.
     * 하지만 다른 클래스와 결합이 생기는 등 트레이드오프가 어느정도 생겼다.
     * @param audience 관람객
     */
    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

    private fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}