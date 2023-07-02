package yangsooplus.ch11

import java.time.Duration
import java.time.LocalDateTime

data class Call(
    val duration: Duration,
    val from: LocalDateTime
)
