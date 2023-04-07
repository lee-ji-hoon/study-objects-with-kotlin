package ezhoon.chapter04

import java.math.BigDecimal

data class Money(
    private val amount: BigDecimal
) {
    fun plus(other: Money): Money {
        return Money(this.amount.add(other.amount))
    }

    fun minus(other: Money): Money {
        return Money(this.amount.subtract(other.amount))
    }

    fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal(percent)))
    }

    fun isLessThan(other: Money) = amount < other.amount

    fun isGreaterThan(other: Money) = amount >= other.amount

    companion object {
        val ZERO = getWons(0)

        fun getWons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun getWons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
