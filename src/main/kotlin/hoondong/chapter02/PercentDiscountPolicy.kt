package hoondong.chapter02

class PercentDiscountPolicy (
    private val percent: Double,
    vararg conditions: DiscountCondition
): DiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}