package nemo

import nemo.common.logging.createLogger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.config.BootstrapMode.LAZY

/**
 * NEMO 메인 클래스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@EntityScan
@EnableJpaRepositories(bootstrapMode = LAZY) // JPA 저장소 스캔
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
