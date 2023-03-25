package hoondong.chapter02

import java.math.BigDecimal

class Money(private var amount: BigDecimal) {
    fun wons(amount: Long): Money {
        return Money(BigDecimal.valueOf(amount))
    }

    fun plus(amount: Money): Money {
        return Money(this.amount + amount.amount)
    }

    fun minus(amount: Money): Money {
        return Money(this.amount - amount.amount)
    }

    fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }

    companion object {
        val ZERO: Money = Money(BigDecimal.ZERO)
    }
}