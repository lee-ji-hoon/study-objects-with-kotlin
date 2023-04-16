package yangsooplus.ch04

import java.lang.IllegalArgumentException
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD) throw IllegalArgumentException()
        return this.dayOfWeek == dayOfWeek && startTime <= time && endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.SEQUENCE) throw IllegalArgumentException()
        return this.sequence == sequence
    }
}

enum class DiscountConditionType{
    SEQUENCE, PERIOD
}