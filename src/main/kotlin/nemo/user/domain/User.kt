package nemo.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

/**
 * 사용자 엔티티
 *
 * @property id 사용자 식별자
 * @property username 사용자 계정
 * @property joinedAt 가입일시
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Entity
@Table(name = "users")
class User(

  @Id
  @Column(name = "id", updatable = false)
  val id: Long = 0,

  @Column(name = "username", updatable = false, unique = true)
  val username: String,

  @Column(name = "joined_at")
  val joinedAt: Instant = Instant.now(),
)
