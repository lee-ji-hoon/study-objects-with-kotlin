package hoondong.chapter05

// Interface로 바꾸래놓고, 마지막에는 왜 또 class인 상태로 진행하는거야?
interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}