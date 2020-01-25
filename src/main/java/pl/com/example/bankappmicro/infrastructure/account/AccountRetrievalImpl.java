package pl.com.example.bankappmicro.infrastructure.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.account.AccountRetrieval;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
import pl.com.example.bankappmicro.domain.model.account.Account;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountRetrievalImpl implements AccountRetrieval {

    private final AccountRepository accountRepository;

    @Override
    public Account findById(Long accountId) {
        Account account=accountRepository.findById(accountId).orElseThrow(()->new AccountNotFoundException("Account not exist with this id."));
        log.info("Account " + account);
        return account;
    }
}
