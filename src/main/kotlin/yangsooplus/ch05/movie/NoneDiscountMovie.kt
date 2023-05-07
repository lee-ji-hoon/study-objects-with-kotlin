package yangsooplus.ch05.movie

import yangsooplus.ch02.Money
import yangsooplus.ch05.discountcondition.DiscountCondition
import java.time.Duration

class NoneDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}