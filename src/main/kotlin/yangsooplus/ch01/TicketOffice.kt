package yangsooplus.ch01

data class TicketOffice(
    var amount: Long,
    val tickets: MutableList<Ticket>
) {

// 티켓을 파는 행위를 TicketOffice 로 가져왔지만, Audience 에 대한 의존성이 생겨버린다!
// 줄건 줘!!!
//    fun sellTicketTo(audience: Audience) {
//        plusAmount(audience.buy(getTicket()))
//    }

    fun getTicket(): Ticket = tickets.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}