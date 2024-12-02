package nemo

import nemo.common.logging.createLogger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

/**
 * NEMO 메인 클래스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@EntityScan
@SpringBootApplication
class Nemo {
  private val log = createLogger {}

  @EventListener
  protected fun onReady(e: ApplicationReadyEvent) {
    log.info { "NEMO is ready!!" }
  }

  companion object {
    @JvmStatic
    fun main(vararg args: String) {
      runApplication<Nemo>(*args)
    }
  }
}
