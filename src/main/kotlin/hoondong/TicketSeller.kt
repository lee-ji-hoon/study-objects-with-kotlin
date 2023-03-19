package hoondong

class TicketSeller(private val ticketOffice: TicketOffice) {
    fun sellTo(audience: Audience) {
        ticketOffice.sellTicketTo(audience)
    }
}