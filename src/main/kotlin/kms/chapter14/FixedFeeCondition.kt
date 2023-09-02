package kms.chapter14

class FixedFeeCondition : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return listOf(call.interval)
    }
}