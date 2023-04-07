package ezhoon.chapter04.movie

import ezhoon.chapter04.discount.DiscountCondition
import ezhoon.chapter04.Money
import java.time.Duration

data class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
)