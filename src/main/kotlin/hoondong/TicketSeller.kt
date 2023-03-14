package hoondong

class TicketSeller(private val ticketOffice: TicketOffice) {
    /**
     * 문제점 해결
     *
     * 극장에 있는 누구든 매표소에 접근이 불가능해졌다.
     */
    fun sellTo(audience: Audience) {
        val ticket: Ticket = ticketOffice.getTicket()
        val fee = audience.buy(ticket)
        ticketOffice.plusAmount(fee)
    }
}