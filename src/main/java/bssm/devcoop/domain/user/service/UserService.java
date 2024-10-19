package bssm.devcoop.domain.user.service;

import bssm.devcoop.entity.user.User;
import bssm.devcoop.entity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Boolean getUserByUserId(String userId) {
        return userRepository.existsById(userId);
    }

}
