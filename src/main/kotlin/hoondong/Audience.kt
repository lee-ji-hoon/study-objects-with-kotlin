package hoondong

class Audience(private val bag: Bag) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}