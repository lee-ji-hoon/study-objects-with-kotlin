package kms.chapter02.discount

import kms.chapter02.Screening
import java.time.DayOfWeek
import java.time.LocalTime

internal class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.startTime.dayOfWeek == dayOfWeek &&
            screening.startTime.toLocalTime().isAfter(startTime) &&
            screening.startTime.toLocalTime().isBefore(endTime)
    }
}
