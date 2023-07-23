package ezhoon.chapter12

class Professor(
    private val name: String,
    private val lecture: Lecture
) {
    fun compileStatistics(): String {
        return String.format(
            "[%s] %s - Avg: %.1f",
            name, lecture.evaluate(), lecture.average()
        )
    }
}
