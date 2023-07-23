package ezhoon.chapter12

import java.util.stream.Collectors

open class GradeLecture(
    val title: String,
    private val pass: Int,
    private val grades: List<Grade>,
    override val scores: List<Int>,
) : Lecture(title, pass, scores) {
    override fun evaluate(): String {
        return super.evaluate() + ", " + gradeStatistics()
    }

    private fun gradeStatistics(): String {
        return grades.stream()
            .map { grade: Grade -> format(grade) }
            .collect(Collectors.joining(" "))
    }

    private fun format(grade: Grade): String {
        return java.lang.String.format("%s:%d", grade.name, gradeCount(grade))
    }

    private fun gradeCount(grade: Grade): Long {
        return scores.stream()
            .filter { score: Int? -> grade.include(score!!) }
            .count()
    }

    fun average(gradeName: String): Double {
        return grades.stream()
            .filter { each: Grade -> each.isName(gradeName!!) }
            .findFirst()
            .map { grade: Grade -> gradeAverage(grade) }
            .orElse(0.0)
    }

    private fun gradeAverage(grade: Grade): Double {
        return scores.stream()
            .filter { score: Int? -> grade.include(score!!) }
            .mapToInt { obj: Int -> obj }
            .average()
            .orElse(0.0)
    }

    override val evaluationMethod: String
        get() = "Grade"
}
