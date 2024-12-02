package nemo.common.infrastructure

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.AdviceMode.ASPECTJ
import org.springframework.context.annotation.Configuration

/**
 * Spring Cache 설정
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableCaching(mode = ASPECTJ)
class CacheConfig : CacheManagerCustomizer<CaffeineCacheManager> {
  override fun customize(cacheManager: CaffeineCacheManager) {
    cacheManager.isAllowNullValues = false
  }
}
