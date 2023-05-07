package ezhoon.chapter06

import java.time.Duration
import java.time.LocalDateTime

data class Event(
    private val subject: String,
    val from: LocalDateTime,
    val duration: Duration,
) {

    fun isSatisfied(schedule: RecurringSchedule): Boolean = !(from.dayOfWeek != schedule.dayOfWeek || from.toLocalTime() != schedule.from || duration != schedule.duration)

    fun reschedule(schedule: RecurringSchedule): Event = copy(
        from = LocalDateTime.of(
            from.toLocalDate().plusDays(daysDistance(schedule)),
            schedule.from
        ),
        duration = schedule.duration
    )

    private fun daysDistance(schedule: RecurringSchedule): Long = (schedule.dayOfWeek.value - from.dayOfWeek.value).toLong()
}
