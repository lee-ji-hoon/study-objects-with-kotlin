package hoondong

class Audience(private val bag: Bag) {
    /**
     * 문제점 해결
     *
     * 제3자(판매원)이 아닌 본인이 스스로 가방에 초대장을 확인한다.
     */
    fun buy(ticket: Ticket): Long {
        return if (bag.hasInvitation()) {
            bag.setTicket(ticket)
            0L
        } else {
            bag.minusAmount(ticket.fee)
            bag.setTicket(ticket)
            ticket.fee
        }
    }
}