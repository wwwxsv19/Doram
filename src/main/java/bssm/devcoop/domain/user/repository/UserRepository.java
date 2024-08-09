package bssm.devcoop.domain.user.repository;

import bssm.devcoop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
