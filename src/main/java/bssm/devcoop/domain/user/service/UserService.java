package bssm.devcoop.domain.user.service;

import bssm.devcoop.entity.user.User;
import bssm.devcoop.entity.user.repository.UserRepository;
import bssm.devcoop.global.exception.GlobalException;
import bssm.devcoop.global.exception.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user) throws GlobalException{
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new GlobalException(ErrorCode.USER_SERVER_ERROR, "유저 생성 중 에러가 발생하였습니다.");
        }
    }

    @Transactional
    public User getUserById(String userId) throws GlobalException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND, "유저를 찾을 수 없습니다."));
    }

    @Transactional
    public Boolean isUserExistsById(String userId) {
        return userRepository.existsById(userId);
    }

}
