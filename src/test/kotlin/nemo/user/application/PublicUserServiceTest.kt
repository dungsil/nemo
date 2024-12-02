package nemo.user.application

import nemo.user.application.test.MockUserServiceTest
import nemo.user.domain.UserRepository
import kotlin.test.Test
import kotlin.test.assertNotNull

class PublicUserServiceTest : MockUserServiceTest<PublicUserService>() {
  override fun setupService(repo: UserRepository) = PublicUserService(repo)

  @Test
  fun test() {
    assertNotNull(service)
  }
}
