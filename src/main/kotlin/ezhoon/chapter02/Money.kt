package ezhoon.chapter02

import java.math.BigDecimal

/**
 * @property amount 가격 (BigDecimal은 Java언어에서 숫자를 정밀하게 저장하고 표현할 수 있는 유일한 방법이다.)
 * - double도 소수점을 표현하지만 정밀도에 있어 한계가 있어 값 유실이 존재한다.
 * - 돈과 소수점을 다룬다면 BigDecimal은 필수적이고 단점으로는 느린 속도와 기본 타입보다 조금 불편한 사용이다.
 */
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