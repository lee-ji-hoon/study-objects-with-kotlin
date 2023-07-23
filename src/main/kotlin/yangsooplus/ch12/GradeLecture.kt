package yangsooplus.ch12

class GradeLecture(
    pass: Int,
    title: String,
    scores: List<Int>,
    private val grades: List<Grade>
) : Lecture(pass, title, scores) {

    override fun evaluate(): String {
        return super.evaluate() + ", " + gradesStatistics()
    }

    private fun gradesStatistics(): String {
        return grades.joinToString(" ") { format(it) }
    }

    private fun format(grade: Grade): String {
        return String.format("${grade.name}:${gradeCount(grade)}")
    }

    private fun gradeCount(grade: Grade): Int {
        return scores.count { grade.include(it) }
    }
}