package ezhoon.chapter12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Lecture")
class LectureTest {
    fun givenLecture(): Lecture {
        return Lecture(
            "object",
            70, mutableListOf(80, 95, 72, 50, 40)
        )
    }

    @Nested
    @DisplayName("evaluate 메소드")
    inner class Describe_evaluate {
        @Test
        @DisplayName("이수한 학생의 수와 낙제한 학생의 수를 표현하는 문자열을 리턴한다")
        fun it_returns_formatted_string() {
            val result = givenLecture().evaluate()
            Assertions.assertEquals(result, "Pass:3 Fail:2")
        }
    }
}