package hoondong.chapter04

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {

    fun plus(amount: Money): Money {
        return Money(this.amount + amount.amount)
    }

    fun minus(amount: Money): Money {
        return Money(this.amount - amount.amount)
    }

    fun times(percent: Int): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent.toDouble())))
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
        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}