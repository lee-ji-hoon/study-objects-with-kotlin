package yangsooplus.ch01

data class Audience(
    val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
