package yangsooplus.ch01

data class Theater(val ticketSeller: TicketSeller) {

    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}