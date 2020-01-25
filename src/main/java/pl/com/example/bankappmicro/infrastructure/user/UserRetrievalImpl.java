package pl.com.example.bankappmicro.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.exception.UserNotFoundException;
import pl.com.example.bankappmicro.domain.model.user.User;
import pl.com.example.bankappmicro.domain.user.UserRetrieval;

@Service
@RequiredArgsConstructor
public class UserRetrievalImpl implements UserRetrieval {

    private final UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not exist with this id."));
    }
}
