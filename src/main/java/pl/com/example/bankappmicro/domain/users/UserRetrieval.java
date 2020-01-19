package pl.com.example.bankappmicro.domain.users;

import pl.com.example.bankappmicro.domain.model.users.User;

public interface UserRetrieval {
    User findUserById(Long id);
}
