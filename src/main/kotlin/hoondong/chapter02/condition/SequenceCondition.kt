package hoondong.chapter02.condition

import hoondong.chapter02.Screening

class SequenceCondition(private val sequence: Int) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}