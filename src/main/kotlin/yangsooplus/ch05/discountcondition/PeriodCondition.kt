package yangsooplus.ch05.discountcondition

import yangsooplus.ch05.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
): DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek
                && startTime <= screening.whenScreened.toLocalTime()
                && endTime >= screening.whenScreened.toLocalTime()
    }

}