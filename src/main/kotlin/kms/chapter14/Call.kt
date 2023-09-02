package kms.chapter14

import java.time.Duration
import java.time.LocalDateTime

data class Call(
    val interval: DateTimeInterval,
) {
    val duration: Duration
        get() = interval.duration

    val from: LocalDateTime
        get() = interval.from

    val to: LocalDateTime
        get() = interval.to

    fun splitByDay() : List<DateTimeInterval> = interval.splitByDay()
}