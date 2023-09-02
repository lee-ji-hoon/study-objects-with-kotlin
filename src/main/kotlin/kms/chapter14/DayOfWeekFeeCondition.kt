package kms.chapter14

import java.time.DayOfWeek

class DayOfWeekFeeCondition(
    private val dayOfWeeks: List<DayOfWeek>
) : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return call.interval.splitByDay()
            .filter { dayOfWeeks.contains(it.from.dayOfWeek) }
    }
}