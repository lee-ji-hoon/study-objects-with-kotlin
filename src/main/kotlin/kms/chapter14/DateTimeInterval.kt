package kms.chapter14

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DateTimeInterval(
    val from: LocalDateTime,
    val to: LocalDateTime,
) {
    companion object {
        fun of(from: LocalDateTime, to: LocalDateTime) = DateTimeInterval(from, to)

        fun toMidnight(from: LocalDateTime): DateTimeInterval {
            return DateTimeInterval(
                from,
                LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999_999_999))
            )
        }

        fun fromMidnight(to: LocalDateTime): DateTimeInterval {
            return DateTimeInterval(
                LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)),
                to
            )
        }

        fun during(date: LocalDate): DateTimeInterval {
            return DateTimeInterval(
                LocalDateTime.of(date, LocalTime.of(0, 0)),
                LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999_999_999))
            )
        }
    }

    val duration
        get() = Duration.between(from, to)

    fun splitByDay(): List<DateTimeInterval> {
        if (days > 0) {
            return splitByDay(days)
        }
        return listOf(this)
    }

    private fun splitByDay(days: Long): List<DateTimeInterval> {
        return mutableListOf<DateTimeInterval>().apply {
            add(toMidnight(from))
            for (loop in 1 until days) {
                add(during(from.toLocalDate().plusDays(loop)))
            }
            add(fromMidnight(to))
        }

    }

    private val days
        get() = Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay()).toDays()
}