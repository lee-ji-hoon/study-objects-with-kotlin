package ezhoon.chapter02

class PeriodDiscountPolicy(
    private val percent: Double,
    override val conditions: ArrayList<DiscountCondition>
) : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }

        }
        return Money.ZERO
    }

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}