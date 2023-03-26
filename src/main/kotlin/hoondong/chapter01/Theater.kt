package hoondong.chapter01

class Theater(private val ticketSeller: TicketSeller) {
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}