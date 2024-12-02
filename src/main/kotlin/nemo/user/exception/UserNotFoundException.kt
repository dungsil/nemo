package nemo.user.exception

import nemo.common.exception.BusinessException

/**
 * @author NEMO maintainers
 * @since 2024.1.0
 */
class UserNotFoundException : BusinessException {
  constructor(id: Long, e: Throwable? = null) : super("사용자 ID '$id'를 찾을 수 없습니다.", e)
  constructor(username: String, e: Throwable? = null) : super("사용자 '$username'를 찾을 수 없습니다.", e)
}
