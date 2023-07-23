package ezhoon.chapter12

import java.util.*

open class Lecture(
    private val title: String,
    private val pass: Int,
    private val scores: List<Int> = ArrayList()
) {

    /** 전체 학생들의 평균 성적을 리턴한다.  */
    fun average(): Double {
        return scores.stream()
            .mapToInt { obj: Int -> obj }
            .average()
            .orElse(0.0)
    }

    /** 전체 학생들의 성적을 리턴한다.  */
    fun getScores(): List<Int> {
        return Collections.unmodifiableList(scores)
    }

    /** 강의를 이수한 학생의 수와 낙제한 학생의 수를 형식에 맞게 구성한 문자열을 리턴한다.  */
    open fun evaluate(): String? {
        return String.format("Pass:%d Fail:%d", passCount(), failCount())
    }

    private fun passCount(): Long {
        return scores.stream()
            .filter { score: Int -> score >= pass }
            .count()
    }

    private fun failCount(): Long {
        return scores.size - passCount()
    }

    fun stats(): String {
        return String.format("Title: %s, Evaluation Method: %s", title, evaluationMethod)
    }

    open val evaluationMethod: String?
        get() = "Pass or Fail"
}
