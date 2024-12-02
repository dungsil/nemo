package nemo.user.application

import nemo.user.application.test.MockUserServiceTest
import nemo.user.domain.UserRepository
import kotlin.test.Test
import kotlin.test.assertNotNull

class SelfUserServiceTest : MockUserServiceTest<SelfUserService>() {
  override fun setupService(repo: UserRepository) = SelfUserService(repo)

  @Test
  fun test() {
    assertNotNull(service)
  }
}
