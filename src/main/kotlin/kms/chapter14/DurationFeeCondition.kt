package kms.chapter14

import java.time.Duration

class DurationFeeCondition(
    private val from: Duration,
    private val to: Duration,
) : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        if (call.interval.duration < from) {
            return emptyList()
        }

        return listOf(
            DateTimeInterval.of(
                call.interval.from + from,
                if (call.interval.duration > to) {
                    call.interval.from + to
                } else {
                    call.interval.to
                }
            )
        )
    }
}