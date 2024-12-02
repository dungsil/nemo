package nemo.user.domain

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author NEMO maintainers
 * @since 2024.1.0
 */
interface UserRepository : JpaRepository<User, Long> {
  fun findByUsername(username: String): User?
}
