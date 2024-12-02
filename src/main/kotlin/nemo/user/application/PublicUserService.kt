package nemo.user.application

import nemo.user.domain.UserRepository
import org.springframework.stereotype.Service

/**
 * 공개된 사용자 정보를 제공하는 서비스
 *
 * @author NEMO maintainers
 * @since 2024.1.0
 */
@Service
class PublicUserService(users: UserRepository) : AbstractUserService(users) {
  // TODO: not implemented
}
