package yangsooplus.ch04

import yangsooplus.ch02.Money
import java.time.Duration

class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,

    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
)

enum class MovieType {
    AMOUNT_DISCOUNT, PERCENT_DISCOUNT, NONE_DISCOUNT
}