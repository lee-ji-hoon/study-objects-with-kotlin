package kms.chapter05

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    private val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) {

    fun isSatisfiedBy(screening: Screening): Boolean {
        return when (type) {
            DiscountConditionType.PERIOD -> isSatisfiedByPeriod(screening)
            DiscountConditionType.SEQUENCE -> isSatisfiedBySequence(screening)
        }
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
            startTime <= screening.whenScreened.toLocalTime() &&
            endTime >= screening.whenScreened.toLocalTime()
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}
