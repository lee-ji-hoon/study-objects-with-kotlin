package yangsooplus.ch02

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {

    fun plus(other: Money): Money {
        return Money(amount.add(other.amount))
    }

    fun minus(other: Money): Money {
        return Money(amount.subtract(other.amount))
    }

    fun times(percent: Double): Money {
        return Money(amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun times(percent: Int): Money {
        return Money(amount.multiply(BigDecimal.valueOf(percent.toLong())))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }

    companion object {
        val ZERO = Money.wons(0)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
