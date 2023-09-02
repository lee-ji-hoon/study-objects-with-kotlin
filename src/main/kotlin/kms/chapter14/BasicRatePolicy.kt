package kms.chapter14

abstract class BasicRatePolicy(
    private val feeRules: List<FeeRule>
) : RatePolicy {

    override fun calculateFee(phone: Phone): Money {
        return phone.getCalls()
            .map { call -> calculate(call) }
            .reduce { acc, money -> acc + money }
    }

    private fun calculate(call: Call): Money {
        return feeRules
            .map { rule -> rule.calculateFee(call) }
            .reduce { acc, money -> acc + money }
    }
}