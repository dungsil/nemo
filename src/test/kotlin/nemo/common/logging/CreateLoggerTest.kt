package nemo.common.logging

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertNotNull

internal class CreateLoggerTest {

  @Test
  @DisplayName("createLogger 함수는 올바른 로거 이름을 가진 로거 인스턴스를 생성해야 한다")
  fun createLoggerShouldCreateLoggerInstanceWithCorrectLoggerName() {
    // given
    val loggerName = "nemo.common.logging.CreateLoggerTest"

    // when
    val logger = createLogger { }

    // then
    assertNotNull(logger)
    assert(logger.name.contains(loggerName))
  }
}
