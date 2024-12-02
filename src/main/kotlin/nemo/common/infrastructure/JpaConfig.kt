package nemo.common.infrastructure

import nemo.Nemo
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.config.BootstrapMode.LAZY

/**
 * Spring Data JPA 설정
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(bootstrapMode = LAZY, basePackageClasses = [Nemo::class])
@EnableJpaAuditing(modifyOnCreate = false)
class JpaConfig
