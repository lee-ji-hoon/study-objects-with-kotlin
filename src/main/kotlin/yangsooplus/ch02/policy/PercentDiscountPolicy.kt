package yangsooplus.ch02.policy

import yangsooplus.ch02.Money
import yangsooplus.ch02.Screening
import yangsooplus.ch02.condition.DiscountCondition

class PercentDiscountPolicy(
    private val percent: Double,
    private val conditions: List<DiscountCondition>
): DiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }

}