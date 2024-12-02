package nemo.user.application

import nemo.user.domain.User
import nemo.user.domain.UserRepository
import nemo.user.exception.UserNotFoundException
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable

/**
 * 추상 사용자 서비스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@CacheConfig(cacheNames = ["users"])
abstract class AbstractUserService(protected val users: UserRepository) {

  /**
   * 사용자 조회
   *
   * @param id 사용자 식별자
   * @throws UserNotFoundException 사용자를 찾을 수 없는 경우 발생
   */
  @Cacheable(key = "#id")
  protected open fun getUser(id: Long): User = users.findById(id)
    .orElseThrow { throw UserNotFoundException(id = id) }

  /**
   * 사용자 조회
   *
   * @param username 사용자 계정
   * @throws UserNotFoundException 사용자를 찾을 수 없는 경우 발생
   */
  @Cacheable(key = "#username")
  protected open fun getUser(username: String): User = users.findByUsername(username)
    ?: throw UserNotFoundException(username = username)
}
