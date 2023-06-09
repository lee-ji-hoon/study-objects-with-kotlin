package kms.chapter01

internal class Theater(
    private val ticketSeller: TicketSeller,
) {
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}
