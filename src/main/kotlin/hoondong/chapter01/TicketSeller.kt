package hoondong.chapter01

class TicketSeller(private val ticketOffice: TicketOffice) {
    fun sellTo(audience: Audience) {
        ticketOffice.sellTicketTo(audience)
    }
}