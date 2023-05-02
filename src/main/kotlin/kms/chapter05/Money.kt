package kms.chapter05

import java.math.BigDecimal

class Money(
    private val amount: BigDecimal,
) : Comparable<Money> {
    operator fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    operator fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    operator fun times(value: Int): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(value.toLong())))
    }

    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }

    companion object {
        fun wons(amount: Long) = Money(BigDecimal.valueOf(amount))

        val ZERO = wons(0)
    }
}
