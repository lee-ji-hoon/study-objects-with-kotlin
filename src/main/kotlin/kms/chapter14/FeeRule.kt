package kms.chapter14

class FeeRule(
    private val feeCondition: FeeCondition,
    private val feePerDuration: FeePerDuration,
) {

    fun calculateFee(call: Call): Money {
        return feeCondition.findTimeIntervals(call)
            .map { feePerDuration.calculate(it) }
            .reduce { acc, money -> acc + money }
    }
}