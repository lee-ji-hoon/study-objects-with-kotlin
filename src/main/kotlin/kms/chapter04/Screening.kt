package kms.chapter04

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime,
)
