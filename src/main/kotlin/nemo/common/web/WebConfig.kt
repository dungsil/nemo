package nemo.common.web

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Spring Web MVC 설정
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableWebMvc
class WebConfig : WebMvcConfigurer
