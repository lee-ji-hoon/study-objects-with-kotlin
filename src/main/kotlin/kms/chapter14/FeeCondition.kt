package kms.chapter14

interface FeeCondition {

    fun findTimeIntervals(call: Call): List<DateTimeInterval>
}