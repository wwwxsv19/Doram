package bssm.devcoop.entity.user.repository;

import bssm.devcoop.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserEmail(String userEmail);
}
