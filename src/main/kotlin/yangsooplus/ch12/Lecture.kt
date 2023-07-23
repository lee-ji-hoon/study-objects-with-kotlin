package yangsooplus.ch12

open class Lecture(
    val pass: Int,
    val title: String,
    val scores: List<Int>
) {
    val average get() = scores.average()
    private val passCount get() = scores.count { it >= pass }
    private val failCount get() = scores.size - passCount

    open fun evaluate() = String.format("Pass: $passCount Fail: $failCount")
}
