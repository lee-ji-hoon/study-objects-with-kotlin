package ezhoon.chapter04.discount

import ezhoon.chapter04.movie.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.Period) {
            throw IllegalArgumentException()
        }

        return isSameDayOfWeek(dayOfWeek) && isBeforeOrEqualEndTime(time) && isAfterOrEqualStartTime(time)
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.Sequence) {
            throw IllegalArgumentException()
        }
        return this.sequence == sequence
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

    private fun isSameSequence(
        screening: Screening
    ): Boolean = sequence == screening.sequence
}