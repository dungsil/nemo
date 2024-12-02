package nemo.user.application

import nemo.user.domain.UserRepository
import org.springframework.stereotype.Service

/**
 * 사용자 관리서비스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Service
class ManagementUserService(users: UserRepository) : AbstractUserService(users) {
  // TODO: not implemented
}
