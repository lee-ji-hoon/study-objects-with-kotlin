package hoondong

import hoondong.chapter02.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.*
import kotlin.test.assertEquals

@DisplayName("영화상영 테스트 코드")
class MovieTest {
    private lateinit var avatarAmount: Movie
    private lateinit var avatarPercent: Movie
    private lateinit var avatar: Movie
    private lateinit var titanic: Movie

    @BeforeEach
    fun init() {
        avatarAmount = Movie(
            "아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            AmountDiscountPolicy(Money.wons(800))
        )

        avatarPercent = Movie(
            "아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            PercentDiscountPolicy(0.1)
        )

        avatar = Movie(
            "아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            AmountDiscountPolicy(
                Money.wons(800),
                SequenceCondition(1),
                SequenceCondition(10),
                PeriodCondition(
                    DayOfWeek.MONDAY,
                    LocalTime.of(10, 0),
                    LocalTime.of(11, 59),
                ), PeriodCondition(
                    DayOfWeek.THURSDAY,
                    LocalTime.of(10, 0),
                    LocalTime.of(20, 59)
                )
            )
        )

        titanic = Movie(
            "타이타닉",
            Duration.ofMinutes(180),
            Money.wons(11000),
            PercentDiscountPolicy(
                0.1,
                PeriodCondition(
                    DayOfWeek.TUESDAY,
                    LocalTime.of(14, 0),
                    LocalTime.of(16, 59)
                ), SequenceCondition(2),
                PeriodCondition(
                    DayOfWeek.THURSDAY,
                    LocalTime.of(10, 0),
                    LocalTime.of(13, 59)
                )
            )
        )
    }

    @Test
    @DisplayName("상영 순서 맞을 때 고정 금액 할인 O")
    fun amountDiscountSuccessTest() {
        val screening = Screening(avatar, 1, LocalDateTime.of(LocalDate.of(10, 1, 1), LocalTime.of(10, 1)))
        assertEquals(Money.wons(9200), avatar.calculateMovieFee(screening))
    }

    @Test
    @DisplayName("상영 순서 틀렸을 때 고정 금액 할인 X")
    fun amountDiscountFailTest() {
        val screening = Screening(avatar, 2, LocalDateTime.of(LocalDate.of(10, 1, 1), LocalTime.of(10, 1)))
        assertEquals(Money.wons(10000), avatar.calculateMovieFee(screening))
    }

    @Test
    @DisplayName("시작 시간 맞을 때 비율 금액 할인 O")
    fun percentDiscountSuccessTest() {
        val screening = Screening(titanic, 1, LocalDateTime.of(LocalDate.of(2023, 3, 28), LocalTime.of(15,1)))
        assertEquals(Money.wons(9900).times(1.0), titanic.calculateMovieFee(screening))
    }

    @Test
    @DisplayName("시작 시간 틀렸을 때 비율 금액 할인 X")
    fun percentDiscountFailTest() {
        val screening = Screening(titanic, 1, LocalDateTime.of(LocalDate.of(2023, 3, 27), LocalTime.of(15,1)))
        assertEquals(Money.wons(11000), titanic.calculateMovieFee(screening))
    }
}