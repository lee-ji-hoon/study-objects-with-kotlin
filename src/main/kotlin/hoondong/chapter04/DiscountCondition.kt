package hoondong.chapter04

import java.time.DayOfWeek
import java.time.LocalTime

/**
 * 1. 어떤 데이터를 관리해야 하는가?
 * - 할인 종류, 순번, 요일, 영화 시간
 *
 * 2. 수행할 수 있는 연산이 무엇인가?
 * - 조건에 따른 할인 여부 결정
 */
class DiscountCondition(
    var type: DiscountConditionType,
    var sequence: Int,
    var dayOfWeek: DayOfWeek,
    var startTime: LocalTime,
    var endTime: LocalTime
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }

        return this.dayOfWeek == dayOfWeek &&
                this.startTime <= time &&
                this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.SEQUENCE) {
            throw IllegalArgumentException()
        }

        return this.sequence == sequence
    }
}