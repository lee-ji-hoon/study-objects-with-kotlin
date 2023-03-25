import yangsooplus.ch02.Customer
import yangsooplus.ch02.Money
import yangsooplus.ch02.Movie
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.PeriodCondition
import yangsooplus.ch02.condition.SequenceCondition
import yangsooplus.ch02.policy.AmountDiscountPolicy
import yangsooplus.ch02.policy.PercentDiscountPolicy
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MovieTest {


    @Test
    fun amountDiscountTest() {
        // given
        val avatarDiscountPolicy = AmountDiscountPolicy(
            discountAmount = Money.Companion.wons(800),
            conditions = listOf(
                SequenceCondition(1),
                SequenceCondition(10),
                PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)),
            )
        )
        val avatar = Movie(
            "아바타",
            Duration.ofMinutes(120),
            Money.Companion.wons(10000),
            avatarDiscountPolicy
        )
        val screening = Screening(avatar, 1, LocalDateTime.now())
        val customer = Customer("양수진")

        // when
        val reservation = screening.reserve(customer, 1)

        // then
        assertEquals(BigDecimal(9200), reservation.fee.amount)
    }

    @Test
    fun percentDiscountTest() {
        val titanicDiscountPolicy = PercentDiscountPolicy(
            percent = 0.1,
            conditions = listOf(
                PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                SequenceCondition(2),
                PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
            )
        )
        val titanic = Movie(
            "타이타닉",
            Duration.ofMinutes(180),
            Money.Companion.wons(11000),
            titanicDiscountPolicy
        )
        val screening = Screening(titanic, 2, LocalDateTime.now())
        val customer = Customer("양수진")

        // when
        val reservation = screening.reserve(customer, 1)

        // then
        assertEquals(BigDecimal(9900.0), reservation.fee.amount)
    }
}