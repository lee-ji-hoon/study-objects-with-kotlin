package chapter01

/**
 * 관람객 클래스
 *
 * @property bag : 소지품을 보관하기 위한 가방 클래스
 */
data class Audience(
    private var bag: Bag,
) {

    /**
     * TicketSeller.kt sellToLegacy(audience: Audience) 에서 캡슐화된 코드
     * 이전에는 TicketSeller에서 Audience의 Bag에 접근했기 때문에 Audience은 수동적이며 의존도가 높았다.
     * Bag에 관련된 내용을 Audience로 빼면서 TicketSeller는 Bag을 알 필요가 없어져 캡슐화 + 의존도가 낮아졌다.
     *
     * @param ticket 티켓
     * @return 관람객이 현장에서 지불할 금액
     */
    /*
    fun buyLegacy(ticket: Ticket): Long {
        bag.ticket = ticket

        return if (bag.hasInvitation.not()) {
            bag.minusAmount(ticket.fee)
            ticket.fee
        } else {
            0
        }
    }
    */

    /**
     * Bag에게도 능동적으로 일을 할 책임을 주기 위해서 리팩토링
     * @param ticket 티켓
     * @return 관람객이 현장에서 지불할 금액
     */
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
