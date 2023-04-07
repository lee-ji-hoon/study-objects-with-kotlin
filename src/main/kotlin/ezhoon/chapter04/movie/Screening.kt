package ezhoon.chapter04.movie

import ezhoon.chapter04.movie.Movie
import java.time.LocalDateTime

class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
)