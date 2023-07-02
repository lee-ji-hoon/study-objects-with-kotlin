package hoondong.chapter11

import java.time.Duration
import java.time.LocalDateTime

class Call(val from: LocalDateTime, private val to: LocalDateTime) {
    val duration: Duration
        get() = Duration.between(from, to)
}