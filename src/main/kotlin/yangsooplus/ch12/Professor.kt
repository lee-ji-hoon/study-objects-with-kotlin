package yangsooplus.ch12

class Professor(
    val name: String,
    val lecture: Lecture
) {

    fun compileStatistics(): String {
        return "[${name}] ${lecture.evaluate()} - Avg: ${lecture.average}"
    }
}