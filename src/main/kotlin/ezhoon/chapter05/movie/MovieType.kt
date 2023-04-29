package ezhoon.chapter05.movie

sealed interface MovieType {

    object AmountDiscount : MovieType
    object PercentDiscount: MovieType
    object NoneDiscount: MovieType
}