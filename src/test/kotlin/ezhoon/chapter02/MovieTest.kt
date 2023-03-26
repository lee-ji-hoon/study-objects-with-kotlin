package ezhoon.chapter02

import ezhoon.chapter02.condition.PeriodCondition
import ezhoon.chapter02.condition.SequenceCondition
import ezhoon.chapter02.policy.AmountDiscountPolicy
import ezhoon.chapter02.policy.DiscountPolicy
import ezhoon.chapter02.policy.PercentDiscountPolicy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.*


@DisplayName("Movie 테스트")
class MovieTest {

    @DisplayName("상영 영화가 아바타일 때")
    class MovieAvatar {

        @Test
        @DisplayName("상영 시작 시간이 할인 조건에 맞는다면 고정할인 금액만큼 할인된 금액을 리턴한다")
        fun calculateMovieFee_discount_fee_by_whenScreen() {
            // given
            val 할인_조건에_맞는_상영_시작_시간들 = listOf(
                given_월요일.withHour(10).withMinute(0),
                given_월요일.withHour(11).withMinute(59),
                given_월요일.withHour(10).withMinute(1),
                given_월요일.withHour(11).withMinute(58),
                given_수요일.withHour(10).withMinute(0),
                given_수요일.withHour(20).withMinute(59),
                given_수요일.withHour(10).withMinute(1),
                given_수요일.withHour(11).withMinute(58)
            )
            // when
            val 할인되는_시간에_시작하는_영화들 = 할인_조건에_맞는_상영_시작_시간들.map { 상영시간 -> Screening(given_아바타(), 0, 상영시간) }

            // then
            할인되는_시간에_시작하는_영화들.forEach { 할인되는_시간에_시작하는_상영 ->
                val 계산된_요금 = given_아바타().calculateMovieFee(할인되는_시간에_시작하는_상영)
                assertEquals(given_아바타().getFee().minus(given_고정할인금액), 계산된_요금)
            }
        }

        @Test
        @DisplayName("상영 시작 시간이 할인 조건에 맞지 않는다면 할인되지 않은 금액을 리턴한다")
        fun calculateMovieFee_not_discount_fee_by_whenScreen() {
            // given
            val 할인_조건에_맞지_않는_상영_시작_시간들 = listOf(
                given_월요일.withHour(9).withMinute(59),
                given_월요일.withHour(12).withMinute(0),
                given_수요일.withHour(9).withMinute(59),
                given_수요일.withHour(21).withMinute(0),
                given_화요일.withHour(10).withMinute(0),
                given_화요일.withHour(10).withMinute(1),
                given_화요일.withHour(10).withMinute(30)
            )

            // when
            val 할인_조건에_맞지_않는_영화들 = 할인_조건에_맞지_않는_상영_시작_시간들.map { 상영시간 -> Screening(given_아바타(), -1, 상영시간) }

            // then
            할인_조건에_맞지_않는_영화들.forEach { 할인되는_시간에_시작하는_상영 ->
                val 계산된_요금 = given_아바타().calculateMovieFee(할인되는_시간에_시작하는_상영)
                assertEquals(given_아바타().getFee(), 계산된_요금)
            }
        }

        @Test
        @DisplayName("상영 순번이 할인 조건에 맞는다면 고정할인 금액만큼 할인된 금액을 리턴한다")
        fun calculateMovieFee_discount_fee_by_sequence() {
            // given
            val 지정된_상영_순번 = listOf(1, 10)

            // when
            val 상영_순번에_의해서_할인되는_영화들 = 지정된_상영_순번.map { 상연순서 -> Screening(given_아바타(), 상연순서, given_토요일) }

            // then
            상영_순번에_의해서_할인되는_영화들.forEach { 할인되는_순번의_상영 ->
                val 계산된_요금 = given_아바타().calculateMovieFee(할인되는_순번의_상영)
                assertEquals(given_아바타().getFee().minus(given_고정할인금액), 계산된_요금)
            }
        }

        @Test
        @DisplayName("상영 순번이 할인 조건에 맞지 않는다면 할인되지 않은 금액을 리턴한다.")
        fun calculateMovieFee_discount_not_fee_by_sequence() {
            // given
            val 지정된_상영_순번 = listOf(2, 9)

            // when
            val 상영_순번에_의해서_할인되지않는_영화들 = 지정된_상영_순번.map { 상연순서 -> Screening(given_아바타(), 상연순서, given_토요일) }

            // then
            상영_순번에_의해서_할인되지않는_영화들.forEach { 할인되는_순번의_상영 ->
                val 계산된_요금 = given_아바타().calculateMovieFee(할인되는_순번의_상영)
                assertEquals(given_아바타().getFee(), 계산된_요금)
            }
        }
    }

    @DisplayName("상영 영화가 타이타닉일 때")
    class MovieTitanic {
        @Test
        @DisplayName("상영 시작 시간이 할인 조건에 맞는 다면 지정된 비율만큼 할인된 금액을 리턴한다.")
        fun calculateMovieFee_discount_fee_by_whenScreen() {
            // given
            val 지정된_기간_내의_시간들 = listOf(
                given_화요일.withHour(14).withMinute(0),
                given_화요일.withHour(16).withMinute(59),
                given_화요일.withHour(14).withMinute(1),
                given_화요일.withHour(16).withMinute(58),
            )

            // when
            val 할인되는_시간에_시작하는_영화들 = 지정된_기간_내의_시간들.map { 상영시간 -> Screening(given_타이타닉(), 0, 상영시간) }

            // then
            할인되는_시간에_시작하는_영화들.forEach { 할인되는_시간에_시작하는_상영 ->
                val 계산된_요금 = given_타이타닉().calculateMovieFee(할인되는_시간에_시작하는_상영)
                assertEquals(given_타이타닉().getFee().minus(given_타이타닉().getFee().times(given_할인비율)), 계산된_요금)
            }
        }
    }

    companion object {
        private val given_월요일 = LocalDate.of(2023, Month.MARCH, 20).atStartOfDay()
        private val given_화요일 = given_월요일.plusDays(1)
        private val given_수요일 = given_월요일.plusDays(2)
        private val given_토요일 = given_월요일.plusDays(5)
        private val given_고정할인금액 = Money.getWons(800)
        private val given_할인비율 = 0.1

        private val given_아바타_할인정책: DiscountPolicy = AmountDiscountPolicy(
            given_고정할인금액,
            listOf(
                SequenceCondition(1),
                SequenceCondition(10),
                PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
            )
        )

        private val given_타이타닉_할인정책: DiscountPolicy = PercentDiscountPolicy(
            0.1,
            listOf(
                SequenceCondition(2),
                PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                PeriodCondition(DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
            )
        )


        fun given_아바타(): Movie {
            return Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.getWons(10000),
                given_아바타_할인정책
            )
        }

        fun given_타이타닉(): Movie {
            return Movie(
                "타이타닉",
                Duration.ofMinutes(180),
                Money.getWons(11000),
                given_타이타닉_할인정책
            )
        }
    }
}