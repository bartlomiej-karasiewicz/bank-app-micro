package pl.com.example.bankappmicro.infrastructure.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.account.AccountCreator;
import pl.com.example.bankappmicro.domain.account.AccountGenerator;
import pl.com.example.bankappmicro.domain.exception.UserNotFoundException;
import pl.com.example.bankappmicro.domain.model.user.User;
import pl.com.example.bankappmicro.infrastructure.user.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountCreatorImpl implements AccountCreator {

    private final AccountGenerator accountGenerator;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addAccount(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User not exist with this id."));
        log.info("Found user:" + user);
        user.addAccount(accountGenerator.generateAccount(user));
    }
}
