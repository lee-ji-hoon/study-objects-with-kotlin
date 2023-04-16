package kms.chapter04

import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, whenScreened: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }
        return this.dayOfWeek == dayOfWeek &&
            this.startTime <= whenScreened &&
            this.endTime >= whenScreened
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.SEQUENCE) {
            throw IllegalArgumentException()
        }
        return this.sequence == sequence
    }
}
