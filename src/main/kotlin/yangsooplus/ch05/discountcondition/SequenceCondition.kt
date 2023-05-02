package yangsooplus.ch05.discountcondition

import yangsooplus.ch05.Screening

class SequenceCondition(
    private val sequence: Int
): DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return sequence == screening.sequence
    }

}