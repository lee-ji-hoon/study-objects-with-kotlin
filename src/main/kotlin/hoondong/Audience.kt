package hoondong

class Audience(private val bag: Bag) {
    /**
     * 문제점
     * 1. 누구든 가방에 접근할 수 있다.
     */
    fun getBag() = bag
}