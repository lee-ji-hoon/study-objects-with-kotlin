package ezhoon.chapter02.condition

import ezhoon.chapter02.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {

    /**
     *
     * @param screening 영화 정보
     * @return
     */
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return isSameScreeningDay(screening)
                && isScreeningTimeOverStartTime(screening)
                && isScreeningTimeBeforeEndTime(screening)
    }

    private fun isSameScreeningDay(screening: Screening) = screening.getStartTime().dayOfWeek.equals(dayOfWeek)
    private fun isScreeningTimeOverStartTime(screening: Screening) = startTime <= screening.getStartTime().toLocalTime()
    private fun isScreeningTimeBeforeEndTime(screening: Screening) = endTime >= screening.getStartTime().toLocalTime()
}