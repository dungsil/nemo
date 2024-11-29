package nemo.common.logging

import io.github.oshai.kotlinlogging.KotlinLogging

/**
 * 현재 선언된 위치의 클래스 명을 추론하여 로거 인스턴스를 생성하는 확장 함수
 *
 * @param func 클래스 명 추론을 위해 사용되는 람다 함수로 리플렉션 용도로 사용될 뿐 실제 동작에는 영향을 주지 않음
 * @return 로거 인스턴스
 * @author NEMO maintainers
 * @since 2024.1.0
 */
fun createLogger(func: () -> Unit) = KotlinLogging.logger(func)
