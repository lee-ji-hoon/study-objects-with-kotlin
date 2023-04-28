package kms.chapter05

data class Movie(
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double,
) {

    fun calculateFee(screening: Screening): Money {
        return if (isDiscountable(screening)) {
            fee - calculateDiscountAmount()
        } else {
            fee
        }
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.stream()
            .anyMatch { condition ->
                condition.isSatisfiedBy(screening)
            }
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(): Money {
        return discountAmount
    }

    private fun calculatePercentDiscountAmount(): Money {
        return fee * discountPercent
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }
}
