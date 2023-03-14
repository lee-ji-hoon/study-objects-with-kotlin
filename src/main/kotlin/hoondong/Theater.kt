package hoondong

class Theater(private val ticketSeller: TicketSeller) {
    /**
     * 문제점
     * 1. 각 요소들이 매우 수동적이기 때문에 코드가 이해하기 어렵다.
     * 2. 각 요소들의 세부 내용을 모두 알지 못하면 코드를 이해하기 어렵다.
     * 3. 클래스를 변경할 경우, 다른 클래스에도 수정사항이 생긴다.
     *
     * => 각 클래스를 다른 클래스에 의존하지 않도록 수정
     */
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