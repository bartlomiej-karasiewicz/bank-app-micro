package pl.com.example.bankappmicro.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.example.bankappmicro.domain.model.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
