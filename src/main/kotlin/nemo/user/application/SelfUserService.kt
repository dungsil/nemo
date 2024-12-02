package nemo.user.application

import nemo.user.domain.UserRepository
import org.springframework.stereotype.Service

/**
 * 사용자가 스스로 정보를 수정할 때 사용하는 서비스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Service
class SelfUserService(users: UserRepository) : AbstractUserService(users) {
  // TODO: not implemented
}
