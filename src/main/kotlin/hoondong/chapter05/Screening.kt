package hoondong.chapter05

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    /** Movie의 구현에 대한 지식 없이 전송할 메시지를 결정함.
     *
     * Movie가 calculateMovieFee라는 함수만 구현한다면
     * Movie의 구현이 변경되더라도 Screening의 구현은 영향을 받지 않음
     * (그렇게 설계를 했으므로 무조건 구현해야함)
     **/
    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}