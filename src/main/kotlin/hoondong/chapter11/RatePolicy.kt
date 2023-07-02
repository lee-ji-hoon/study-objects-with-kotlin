package hoondong.chapter11

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}