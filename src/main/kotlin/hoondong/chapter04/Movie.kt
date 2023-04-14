package hoondong.chapter04

data class Movie(
    private val title: String,
    private val runningTime: java.time.Duration,
    var fee: Money,
    var discountConditions: List<DiscountCondition>,
    var movieType: MovieType,
    var discountAmount: Money,
    var discountPercent: Double
)