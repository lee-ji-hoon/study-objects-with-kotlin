package kms.chapter04

import java.math.BigDecimal

internal class Money(
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

    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }

    companion object {
        fun wons(amount: Long) = Money(BigDecimal.valueOf(amount))

        val ZERO = wons(0)
    }
}
