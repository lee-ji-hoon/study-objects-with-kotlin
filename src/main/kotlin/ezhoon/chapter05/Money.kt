package ezhoon.chapter05

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

    operator fun times(percent: Int): Money {
        return Money(this.amount.multiply(BigDecimal(percent)))
    }

    companion object {
        val ZERO = getWons(0)

        private fun getWons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun getWons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
