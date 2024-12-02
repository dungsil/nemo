package nemo.common.infrastructure

import org.springframework.cache.annotation.EnableCaching
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
class CacheConfig
