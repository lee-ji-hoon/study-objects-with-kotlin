package ezhoon.chapter01

import ezhoon.chapter01.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DisplayName("관람객 클래스 테스트")
class AudienceTest {

    private lateinit var ticketSeller: TicketSeller
    private lateinit var ticketOffice: TicketOffice
    private lateinit var theater: Theater

    @BeforeEach
    fun initTheater() {
        ticketOffice = TicketOffice(10, tickets)
        ticketSeller = TicketSeller(ticketOffice)
        theater = Theater(ticketSeller)
    }

    @Test
    @DisplayName("티켓/초대권이 없는 경우 티켓 금액만큼 현재 갖고 있는 금액에서 빼고 티켓을 갖고 있어야 한다.")
    fun noHaveTicketAudience() {
        // given
        val bag = Bag(audienceInitAmount)
        val audience = Audience(bag)
        // when
        theater.enter(audience)
        // then
        assertEquals(bag.getAmount(), audienceInitAmount - ticket.fee)
        assertTrue(bag.hasTicket)
    }

    @Test
    @DisplayName("초대권을 갖고 있는 경우 금액은 그대로고 ticket이 생성돼야 한다.")
    fun haveTicketAudience() {
        // given
        val invitation = Invitation(LocalDateTime.now())
        val bag = Bag(audienceInitAmount, invitation)
        val audience = Audience(bag)
        // when
        theater.enter(audience)
        // then
        assertEquals(bag.getAmount(), audienceInitAmount)
        assertTrue(bag.hasTicket)
    }

    companion object {
        private val ticket = Ticket(10_000L)
        val tickets = generateSequence(ticket) { it }
            .take(10)
            .toMutableList()
        private const val audienceInitAmount = 50_000L
    }
}