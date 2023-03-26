package kms.chapter02

import java.time.LocalDateTime

internal class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime,
) {

    val startTime: LocalDateTime
        get() = whenScreened

    val fee: Money
        get() = movie.fee

    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }
}
