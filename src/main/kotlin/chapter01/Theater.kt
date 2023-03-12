package chapter01

class Theater(
    private val ticketSeller: TicketSeller
) {

    /**
     * TODO 리팩토링 대상이다. 역할과 의존성이 현재 이상하다. -> 소극장(Theater)와 너무 많은 것들이 결합돼있다.
     * - 소극장(Theater)가 관람객(Audience)의 가방(Audience.Bag)을 직접 확인
     * - 만약 티켓(Audience.Bag.Ticket)이 없다면 직접 현금(Audience.Bag.Amount)을 꺼내서 지불한다.
     * - 소극장(Theater)가 판매원(TicketSeller)에게 받은 요금(Ticket.Fee)만큼 Amount를 증가시킨다.
     * 관람객과 판매원이 소극장의 통제를 너무 과하게 받는 모습으로 보인다.
     * 현실에서는 관람객이 직접 자신의 가방에서 초대장을 꺼내 판매원에게 건내고, 판매원은 매표소에 있는 티켓을 직접 꺼내서 관람객에게 건내고 돈을 받아 매표소에 보관한다.
     * @param audience 관람객
     */
    /*
    fun enterLegacy(audience: Audience) {
        val ticket = ticketSeller.ticketOffice.getTicket()

        // 티켓이 없다면 방문객의 지갑에서 티켓 요금만큼 사용
        if (audience.bag.hasInvitation.not()) {
            audience.bag.minusAmount(ticket.fee)
            ticketSeller.ticketOffice.plusAmount(ticket.fee)
        }
        audience.bag.ticket = ticket
    }
    */

    /**
     * 소극장(Theater)는 판매자(TicketSeller) 관람객(Audience)가 무슨 일을 하는지 내부적으로 알 필요가 없기에 요청만 하면 된다.
     * @param audience 관람객
     */
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}