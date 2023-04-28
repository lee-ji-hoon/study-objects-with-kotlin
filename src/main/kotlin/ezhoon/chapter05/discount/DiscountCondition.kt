package ezhoon.chapter05.discount

import ezhoon.chapter05.movie.Screening

interface DiscountCondition {

    fun isDisCountable(screening: Screening): Boolean
}