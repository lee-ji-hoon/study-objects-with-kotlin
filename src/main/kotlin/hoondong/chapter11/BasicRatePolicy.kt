package hoondong.chapter11

abstract class BasicRatePolicy : RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        var result = Money.ZERO
        phone.getCalls().forEach {
            result += calculateCallFee(it)
        }
        return result
    }

    protected abstract fun calculateCallFee(call: Call): Money
}