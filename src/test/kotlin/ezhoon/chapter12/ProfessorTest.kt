package ezhoon.chapter12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

@DisplayName("Professor")
class ProfessorTest {
    @Nested
    @DisplayName("compileStatistics 메소드")
    inner class Describe_compileStatistics {
        @Nested
        @DisplayName("다익스트라 교수의 알고리즘 Lecture 라면")
        inner class Context_with_dijkstra {

            @Test
            @DisplayName("이수한 학생의 수, 낙제한 학생의 수, 평균을 표현하는 문자열을 리턴한다")
            fun it_returns_statistics() {
                val result = givenProfessor().compileStatistics()
                Assertions.assertEquals(result, "[다익스트라] Pass:3 Fail:2 - Avg: 69.2")
            }

            private fun givenProfessor(): Professor {
                return Professor(
                    "다익스트라",
                    Lecture("알고리즘", 70, mutableListOf(81, 95, 75, 50, 45))
                )
            }
        }

        @Nested
        @DisplayName("다익스트라 교수의 알고리즘 GradeLecture 라면")
        inner class Context_with_dijkstra_grade_lecture {
            @Test
            @DisplayName("이수한 학생의 수, 낙제한 학생의 수, 각 학점별 수, 평균을 표현하는 문자열을 리턴한다")
            fun it_returns_statistics() {
                val result = givenProfessor().compileStatistics()
                Assertions.assertEquals(result, "[다익스트라] Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1 - Avg: 69.2")
            }

            private fun givenProfessor(): Professor {
                return Professor(
                    "다익스트라",
                    GradeLecture(
                        "알고리즘", 70,
                        listOf(
                            Grade("A", 100, 95),
                            Grade("B", 94, 80),
                            Grade("C", 79, 70),
                            Grade("D", 69, 50),
                            Grade("F", 49, 0)
                        ), mutableListOf(81, 95, 75, 50, 45)
                    )
                )
            }
        }
    }
}