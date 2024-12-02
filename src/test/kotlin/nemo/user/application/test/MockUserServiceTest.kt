package nemo.user.application.test

import nemo.user.application.AbstractUserService
import nemo.user.domain.UserRepository
import org.mockito.Mockito.mock
import kotlin.test.BeforeTest

abstract class MockUserServiceTest<SERVICE : AbstractUserService> {
  protected lateinit var repo: UserRepository
  protected lateinit var service: SERVICE

  @BeforeTest
  protected open fun setup() {
    this.repo = mock()
    this.service = setupService(repo)
  }

  protected abstract fun setupService(repo: UserRepository): SERVICE
}
