package yangsooplus.ch01

data class Audience(
    val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        bag.ticket = ticket

        return if (bag.hasInvitation()) {
            0L
        } else {
            bag.minusAmount(ticket.fee)
            ticket.fee
        }
    }
}
