package ezhoon.chapter05.discount

import ezhoon.chapter05.movie.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
): DiscountCondition {
    override fun isDisCountable(screening: Screening): Boolean {
        val time = screening.whenScreened.toLocalTime()
        return isSameDayOfWeek(dayOfWeek) && isBeforeOrEqualEndTime(time) && isAfterOrEqualStartTime(time)
    }

    private fun isBeforeOrEqualEndTime(
        time: LocalTime
    ): Boolean = endTime >= time

    private fun isAfterOrEqualStartTime(
        time: LocalTime
    ): Boolean = startTime <= time

    private fun isSameDayOfWeek(
        dayOfWeek: DayOfWeek
    ): Boolean = dayOfWeek == this.dayOfWeek
}