package hoondong.chapter02.condition

import hoondong.chapter02.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.getStartTime().dayOfWeek == dayOfWeek &&
                startTime <= screening.getStartTime().toLocalTime() &&
                endTime >= screening.getStartTime().toLocalTime()
    }
}