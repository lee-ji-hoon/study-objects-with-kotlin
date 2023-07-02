package hoondong.chapter11

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {

    operator fun plus(amount: Money): Money {
        return Money(this.amount + amount.amount)
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount - amount.amount)
    }

    operator fun times(percent: Int): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent.toDouble())))
    }

    operator fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    operator fun times(percent: Long): Money {
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