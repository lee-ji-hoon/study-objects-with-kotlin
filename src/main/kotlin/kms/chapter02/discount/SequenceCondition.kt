package kms.chapter02.discount

import kms.chapter02.Screening

internal class SequenceCondition(private val sequence: Int) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}
