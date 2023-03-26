package ezhoon.chapter02

/**
 * 할인 정책은 다양하게 존재한다.
 * 1. 비율 할인
 * 2. 일정 금액 할인
 * 둘 다 동일하게 할인을 하기에 추상화가 가능하다.
 */
interface DiscountPolicy {

    val conditions: ArrayList<DiscountCondition>
    fun calculateDiscountAmount(screening: Screening): Money

    fun getDiscountAmount(screening: Screening): Money
}
