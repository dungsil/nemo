package nemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * NEMO 메인 클래스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@SpringBootApplication
class Nemo {
  companion object {
    @JvmStatic
    fun main(vararg args: String) {
      runApplication<Nemo>(*args)
    }
  }
}
