package nemo

import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod.ALWAYS
import kotlin.test.Test

@SpringBootTest(useMainMethod = ALWAYS)
internal class NemoIntegrationTests {

  @Test
  @DisplayName("어플리케이션은 정상적으로 실행되어야 한다.")
  fun contextLoads() {

  }
}