package nemo.user.application

import nemo.user.application.test.MockUserServiceTest
import nemo.user.domain.User
import nemo.user.domain.UserRepository
import nemo.user.exception.UserNotFoundException
import org.junit.jupiter.api.DisplayName
import org.mockito.Mockito
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AbstractUserServiceTest : MockUserServiceTest<AbstractUserServiceTest.TestUserService>() {
  // protected 메소드 테스트를 위한 테스트용 서비스 클래스
  class TestUserService(repo: UserRepository) : AbstractUserService(repo) {
    fun getUserById(id: Long): User = getUser(id)
    fun getUserByUsername(username: String): User = getUser(username)
  }

  override fun setupService(repo: UserRepository) = TestUserService(repo)

  @Test
  @DisplayName("getUser 함수는 존재하는 사용자의 ID 값을 받으면 사용자를 반환해야한다")
  fun getUserByIdShouldReturnUserWhenUserExists() {
    // given
    val id = 1L
    val user = User(id = id, username = "testUser")

    // when
    Mockito.`when`(repo.findById(id)).thenReturn(Optional.of(user))
    val result = service.getUserById(id)

    // then
    assertEquals(user, result)
  }

  @Test
  @DisplayName("getUser 함수는 존재하지 않는 사용자의 ID 값을 받으면 UserNotFoundException 예외를 발생시켜야한다")
  fun getUserByIdShouldThrowUserNotFoundExceptionWhenUserDoesNotExist() {
    // given
    val id = 1L

    // when
    Mockito.`when`(repo.findById(id)).thenReturn(Optional.empty())

    // then
    assertFailsWith<UserNotFoundException> {
      service.getUserById(id)
    }
  }

  @Test
  @DisplayName("getUser 함수는 존재하는 사용자의 username 값을 받으면 사용자를 반환해야한다")
  fun getUserByUsernameShouldReturnUserWhenUserExists() {
    // given
    val username = "testUser"
    val user = User(id = 1L, username = username)

    // when
    Mockito.`when`(repo.findByUsername(username)).thenReturn(user)
    val result = service.getUserByUsername(username)

    // then
    assertEquals(user, result)
  }

  @Test
  @DisplayName("getUser 함수는 존재하지 않는 사용자의 username 값을 받으면 UserNotFoundException 예외를 발생시켜야한다")
  fun getUserByUsernameShouldThrowUserNotFoundExceptionWhenUserDoesNotExist() {
    // given
    val username = "testUser"

    // when
    Mockito.`when`(repo.findByUsername(username)).thenReturn(null)

    // then
    assertFailsWith<UserNotFoundException> {
      service.getUserByUsername(username)
    }
  }
}
