package yangsooplus.ch12

class Grade(
    val name: String,
    private val upper: Int,
    private val lower: Int
) {
    fun isName(name: String): Boolean {
        return this.name == name
    }

    fun include(score: Int): Boolean {
        return score in lower..upper
    }
}