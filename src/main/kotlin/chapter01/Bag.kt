package chapter01

/**
 * 관람객이 소지품을 보관할 클래스
 *
 * @property amount : 가격
 * @property invitation : 초대장
 * @property ticket : 티켓
 */
data class Bag(
    var amount: Long,
    var invitation: Invitation? = null,
    var ticket: Ticket? = null,
) {
    val hasInvitation: Boolean
        get() = invitation != null
    val hasTicket: Boolean
        get() = ticket != null

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
