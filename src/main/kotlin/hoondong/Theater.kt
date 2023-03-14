package hoondong

class Theater(private val ticketSeller: TicketSeller) {
    fun enter(audience: Audience) {
        if (audience.getBag().hasInvitation()) {
            val ticket: Ticket = ticketSeller.getTicketOffice().getTicket()
            audience.getBag().setTicket(ticket)
        } else {
            val ticket = ticketSeller.getTicketOffice().getTicket()
            audience.getBag().minusAmount(ticket.fee)
            ticketSeller.getTicketOffice().plusAmount(ticket.fee)
            audience.getBag().setTicket(ticket)
        }
    }
}