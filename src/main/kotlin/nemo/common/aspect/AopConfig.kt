package nemo.common.aspect

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * AspectJ 설정
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableAspectJAutoProxy
class AopConfig
