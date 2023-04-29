package ezhoon.chapter05.discount

import ezhoon.chapter05.movie.Screening

class SequenceCondition(
    private val sequence: Int
): DiscountCondition {
    override fun isDisCountable(screening: Screening): Boolean {
        return this.sequence == sequence
    }
}