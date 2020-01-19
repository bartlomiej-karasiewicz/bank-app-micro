package pl.com.example.bankappmicro.domain.user;

import pl.com.example.bankappmicro.domain.model.user.User;

public interface UserRetrieval {
    User findUserById(Long id);
}
