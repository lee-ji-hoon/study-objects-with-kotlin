package yangsooplus.ch06

import java.time.Duration
import java.time.LocalDateTime

class Event(
    private val subject: String,
    private var from: LocalDateTime,
    private val duration: Duration
) {
    fun isSatisfied(schedule: RecurringSchedule): Boolean {
        if (from.dayOfWeek != schedule.dayOfWeek
            || from.toLocalTime() != schedule.from.toLocalTime()
            ||duration != schedule.duration) {
            reschedule(schedule) // 여기는 명령
            return false // 여기는 쿼리 -> 쿼리 반환하기 전에
        }

        return true
    }

    private fun reschedule(schedule: RecurringSchedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)), schedule.from.toLocalTime())
    }

    private fun dayDistance(schedule: RecurringSchedule): Long {
        return (schedule.dayOfWeek.value - from.dayOfWeek.value).toLong()
    }
}