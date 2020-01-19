package pl.com.example.bankappmicro.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.example.bankappmicro.domain.model.users.User;

interface UserRepository extends JpaRepository<User,Long> {
}
