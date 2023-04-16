package kms.chapter04

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

data class DiscountCondition(
    private val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) {

    fun isDiscountable(screening: Screening): Boolean{
        return when(type){
            DiscountConditionType.PERIOD -> isPeriod(screening.whenScreened)
            DiscountConditionType.SEQUENCE -> isSequence(screening.sequence)
        }
    }

    private fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    private fun isPeriod(whenScreening: LocalDateTime): Boolean {
        return whenScreening.dayOfWeek == dayOfWeek &&
            startTime <= whenScreening.toLocalTime() &&
            endTime >= whenScreening.toLocalTime()
    }
}
