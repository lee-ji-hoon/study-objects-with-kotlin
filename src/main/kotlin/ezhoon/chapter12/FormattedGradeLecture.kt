package ezhoon.chapter12

class FormattedGradeLecture(
    private val name: String,
    private val pass: Int,
    override val scores: List<Int>,
    private val grades: List<Grade>,
) : GradeLecture(name, pass, grades, scores) {

    fun formatAverage(): String {
        return String.format("Avg: %1.1f", super.average())
    }
}
