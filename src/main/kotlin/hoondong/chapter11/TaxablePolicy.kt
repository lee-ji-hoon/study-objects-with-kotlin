package hoondong.chapter11

class TaxablePolicy(private val taxRate: Double): BasicRatePolicy() {

    override fun calculateCallFee(call: Call): Money {
        TODO("Not yet implemented")
    }

    override fun calculateFee(phone: Phone): Money {
        val fee = super.calculateFee(phone)
        return fee + fee * taxRate
    }
}