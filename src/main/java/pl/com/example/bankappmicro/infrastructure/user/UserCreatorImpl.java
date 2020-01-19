package pl.com.example.bankappmicro.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.user.UserBuilder;
import pl.com.example.bankappmicro.domain.user.UserCreator;

@Service
@RequiredArgsConstructor
class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(UserBuilder userBuilder) {
        userRepository.save(userBuilder.generateUser());
    }

}
