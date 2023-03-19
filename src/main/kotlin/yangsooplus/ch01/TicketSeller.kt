package yangsooplus.ch01

data class TicketSeller(
    private val ticketOffice: TicketOffice
) {

    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
    }
}
