package yangsooplus.ch04

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    val type: DiscountConditionType,
    val sequence: Int,
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime
)

enum class DiscountConditionType{
    SEQUENCE, PERIOD
}