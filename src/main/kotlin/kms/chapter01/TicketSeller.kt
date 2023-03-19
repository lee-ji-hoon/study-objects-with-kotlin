package kms.chapter01

internal class TicketSeller(
    private val ticketOffice: TicketOffice,
) {

    fun sellTo(audience: Audience) {
        val ticket = ticketOffice.getTicket()
        if (ticket != null) {
            val amount = audience.buy(ticket)
            ticketOffice.plusAmount(amount)
        }
    }
}
