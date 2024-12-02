package nemo.common.exception

/**
 * 비지니스 예외
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
abstract class BusinessException(
  override val message: String? = null,
  override val cause: Throwable? = null,
) : RuntimeException(message, cause)
