package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
