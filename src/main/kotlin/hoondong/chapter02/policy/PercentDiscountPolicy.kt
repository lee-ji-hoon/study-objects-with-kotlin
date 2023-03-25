package hoondong.chapter02.policy

import hoondong.chapter02.condition.DiscountCondition
import hoondong.chapter02.Money
import hoondong.chapter02.Screening

class PercentDiscountPolicy (
    private val percent: Double,
    vararg conditions: DiscountCondition
): DefaultDiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}