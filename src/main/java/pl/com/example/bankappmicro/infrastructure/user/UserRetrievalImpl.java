package pl.com.example.bankappmicro.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.model.users.User;
import pl.com.example.bankappmicro.domain.users.UserRetrieval;

@Service
@RequiredArgsConstructor
public class UserRetrievalImpl implements UserRetrieval {

    private final UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
}
