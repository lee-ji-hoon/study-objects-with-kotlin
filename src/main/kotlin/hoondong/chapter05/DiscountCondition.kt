package hoondong.chapter05

import hoondong.chapter04.DiscountConditionType
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    var type: DiscountConditionType,
    var sequence: Int,
    var dayOfWeek: DayOfWeek,
    var startTime: LocalTime,
    var endTime: LocalTime
) {
    fun isSatisfiedBy(screening: Screening): Boolean {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening)
        }

        return isSatisfiedBySequence(screening)
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
                this.startTime <= screening.whenScreened.toLocalTime() &&
                this.endTime >= screening.whenScreened.toLocalTime()
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}