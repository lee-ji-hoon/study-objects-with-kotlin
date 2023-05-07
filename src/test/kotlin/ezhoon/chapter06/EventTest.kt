package ezhoon.chapter06

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.*

class EventTest {

    @Test
    @DisplayName("반복일정 테스트 코드")
    fun recurringScheduleTest() {
        // given
        val schedule = RecurringSchedule(
            "회의",
            DayOfWeek.WEDNESDAY,
            LocalTime.of(10, 30),
            Duration.ofMinutes(30)
        )
        val meeting = Event(
            "회의",
            LocalDateTime.of(2019,5,8,10,30),
            Duration.ofMinutes(30)
        )
        // when -> 이 테코에는 여기 뭐 들어가야하지?


        // then
        assertTrue(meeting.isSatisfied(schedule))
        assertTrue(meeting.reschedule(schedule).duration == schedule.duration)
    }
}