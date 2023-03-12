package chapter01

data class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    /**
     * Theater.kt fun enterLegacy(audience: Audience) 에서 캡슐화된 코드
     * TicketOffice가 private객체가 되면서 세부적인 사항이 감쳐졌다 -> 캡슐화 + 결합도 낮춤
     * 하지만 지금도 관람객(Audience)의 Bag에 접근을 하고 있어서 의존도가 너무 높다! 리팩토링 하자!
     * @param audience 관람객
     */
    /*
    fun sellToLegacy(audience: Audience) {
        val ticket = ticketOffice.getTicket()

        // 티켓이 없다면 방문객의 지갑에서 티켓 요금만큼 사용
        if (audience.bag.hasInvitation.not()) {
            audience.bag.minusAmount(ticket.fee)
            ticketOffice.plusAmount(ticket.fee)
        }
        audience.bag.ticket = ticket
    }
    */

    /**
     * 관람객(Audience)의 Bag관련된 내용은 Audience가 처리하게 변경이 됐다.
     * 이렇게 함으로써 Bag의 내부 구현이 변경이 되더라도 TicketSeller는 아무런 영향을 받지 않는다.
     * @param audience 관람객
     */
    fun sellTo(audience: Audience) {
        val ticket = ticketOffice.getTicket()
        val amount = audience.buy(ticket)
        ticketOffice.plusAmount(amount)
    }
}
