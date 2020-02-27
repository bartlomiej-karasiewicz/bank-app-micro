package pl.com.example.bankappmicro.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.user.UserCommand;
import pl.com.example.bankappmicro.domain.user.UserCreator;

@Service
@RequiredArgsConstructor
public
class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(UserCommand userCommand) {
        userRepository.save(userCommand.generateUser());
    }

}
