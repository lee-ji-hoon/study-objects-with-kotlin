package kms.chapter14

import java.time.LocalDateTime
import java.time.LocalTime

class TimeOfDayFeeCondition(
    private val from: LocalTime,
    private val to: LocalTime,
) : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return call.interval.splitByDay()
            .filter { from(it).isBefore(to(it)) }
            .map {
                DateTimeInterval.of(
                    LocalDateTime.of(it.from.toLocalDate(), from(it)),
                    LocalDateTime.of(it.to.toLocalDate(), to(it)),
                )
            }
    }

    private fun from(interval: DateTimeInterval): LocalTime {
        return if(interval.from.toLocalTime().isBefore(from)) from else interval.from.toLocalTime()
    }

    private fun to(interval: DateTimeInterval): LocalTime {
        return if(interval.to.toLocalTime().isAfter(to)) to else interval.to.toLocalTime()
    }
}