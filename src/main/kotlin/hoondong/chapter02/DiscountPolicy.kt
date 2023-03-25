package hoondong.chapter02

abstract class DiscountPolicy(
    vararg tempConditions: DiscountCondition
) {
    private val conditions: List<DiscountCondition> = listOf(*tempConditions)

    fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach { each ->
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}