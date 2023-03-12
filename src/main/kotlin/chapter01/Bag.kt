package chapter01

/**
 * 관람객이 소지품을 보관할 클래스
 *
 * @property amount : 가격
 * @property invitation : 초대장
 * @property ticket : 티켓
 */
data class Bag(
    private var amount: Long,
    private var invitation: Invitation? = null,
    private var ticket: Ticket? = null,
) {
    private val hasInvitation: Boolean
        get() = invitation != null
    val hasTicket: Boolean
        get() = ticket != null

    fun hold(ticket: Ticket): Long {
        this.ticket = ticket

        return if (hasInvitation.not()) {
            minusAmount(ticket.fee)
            ticket.fee
        } else {
            0
        }
    }

    fun getAmount(): Long {
        return amount
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
