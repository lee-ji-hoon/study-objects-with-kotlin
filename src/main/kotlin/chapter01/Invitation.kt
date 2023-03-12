package chapter01

import java.time.LocalDateTime

/**
 * 초대장
 *
 * @property whenTime : 공연 시간
 */
data class Invitation(
    val whenTime: LocalDateTime,
)
