package ezhoon.chapter12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

@DisplayName("GradeLecture")
internal class GradeLectureTest {
    fun givenLecture(): Lecture {
        return GradeLecture(
            "오브젝트",
            70,
            listOf(
                Grade("A", 100, 95),
                Grade("B", 94, 80),
                Grade("C", 79, 70),
                Grade("D", 69, 50),
                Grade("F", 49, 0)
            ), mutableListOf(81, 95, 75, 50, 45)
        )
    }

    @Nested
    @DisplayName("evaluate 메소드")
    internal inner class Describe_evaluate {
        @Test
        @DisplayName("이수한 학생의 수와 낙제한 학생의 수를 표현하는 문자열을 리턴한다")
        fun it_returns_formatted_string() {
            val result = givenLecture().evaluate()
            Assertions.assertEquals(result, "Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1")
        }
    }
}