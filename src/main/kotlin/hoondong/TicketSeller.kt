package hoondong

class TicketSeller(private val ticketOffice: TicketOffice) {
    /**
     * 문제점
     * 1. 누구든 매표소에 접근 가능하다.
     */
    fun getTicketOffice() = ticketOffice
}