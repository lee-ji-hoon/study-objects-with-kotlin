package chapter01

class Theater(
    private val ticketSeller: TicketSeller
) {

    fun enter(audience: Audience) {
        val ticket = ticketSeller.ticketOffice.getTicket()

        // 티켓이 없다면 방문객의 지갑에서 티켓 요금만큼 사용
        if (audience.bag.hasInvitation.not()) {
            audience.bag.minusAmount(ticket.fee)
            ticketSeller.ticketOffice.plusAmount(ticket.fee)
        }
        audience.bag.ticket = ticket
    }
}