package pl.com.example.bankappmicro.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.users.UserBuilder;
import pl.com.example.bankappmicro.domain.users.UserCreator;

@Service
@RequiredArgsConstructor
class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public void addUser(UserBuilder userBuilder) {
        userRepository.save(userBuilder.generateUser());
    }
}
