package hoondong

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

@DisplayName("소극장 테스트코드")
class TheaterTest {
    private lateinit var theater: Theater
    private lateinit var ticketSeller: TicketSeller
    private lateinit var ticketOffice: TicketOffice
    private lateinit var tickets: MutableList<Ticket>

    @BeforeEach
    fun init() {
        tickets = mutableListOf()
        (0..4).forEach { tickets.add(Ticket(1)) }
        ticketOffice = TicketOffice(5, *(tickets.toTypedArray()))
        ticketSeller = TicketSeller(ticketOffice)
        theater = Theater(ticketSeller)
    }

    @Test
    @DisplayName("초대장이 있는 경우 판매원이 티켓을 관객에게 전달한다.")
    fun hasNoInvitation() {
        val bag = Bag(Invitation(LocalDateTime.now()))
        bag.plusAmount(10)
        val audience = Audience(bag)
        theater.enter(audience)

        assertEquals(bag.hasTicket(), true)
        assertEquals(10, bag.amount)
    }

    @Test
    @DisplayName("초대장이 없는 경우 관객이 요금을 지불하고 티켓을 받는다.")
    fun hasInvitation() {
        val bag = Bag().also {
            it.plusAmount(10)
        }
        val audience = Audience(bag)
        theater.enter(audience)

        assertEquals(bag.hasTicket(), true)
        assertEquals(9, bag.amount)
    }
}