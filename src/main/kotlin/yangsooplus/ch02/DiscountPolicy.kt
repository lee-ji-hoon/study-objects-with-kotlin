package yangsooplus.ch02

data class DiscountPolicy(val tmp: Int) {
    fun calculateDiscountAmount(screening: Screening): Money {
        return Money.wons(0L)
    }
}
