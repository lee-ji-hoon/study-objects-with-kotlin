package ezhoon.chapter06

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime

class RecurringSchedule(
    private val subject: String,
    val dayOfWeek: DayOfWeek,
    val from: LocalTime,
    val duration: Duration
)