package yangsooplus.ch02.condition

import yangsooplus.ch02.Screening

class SequenceCondition(private val sequence: Int): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}
