package hoondong.chapter01

class Audience(private val bag: Bag) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}