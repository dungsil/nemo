package nemo.user.application

import nemo.user.application.test.MockUserServiceTest
import nemo.user.domain.UserRepository
import kotlin.test.Test
import kotlin.test.assertNotNull

internal class ManagementUserServiceTest : MockUserServiceTest<ManagementUserService>() {
  override fun setupService(repo: UserRepository) = ManagementUserService(repo)

  @Test
  fun test() {
    assertNotNull(service)
  }
}
