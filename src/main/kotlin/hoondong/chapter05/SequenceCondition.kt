package hoondong.chapter05

class SequenceCondition(
    private val sequence: Int
): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.sequence == sequence
    }
}
