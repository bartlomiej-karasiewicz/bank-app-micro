package pl.com.example.bankappmicro.domain.users;

import pl.com.example.bankappmicro.domain.model.users.Users;

import java.util.Optional;

public interface UserCreator {
    void addUser(UserBuilder userBuilder);
    Optional<Users> getUserById(Long id);
}
