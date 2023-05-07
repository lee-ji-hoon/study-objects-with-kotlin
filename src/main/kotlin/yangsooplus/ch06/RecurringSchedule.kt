package yangsooplus.ch06

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime

class RecurringSchedule(
    private val subject: String,
    val dayOfWeek: DayOfWeek,
    val from: LocalDateTime,
    val duration: Duration
)