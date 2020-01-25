package pl.com.example.bankappmicro.api.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.account.AccountCreator;
import pl.com.example.bankappmicro.domain.account.AccountRetrieval;
import pl.com.example.bankappmicro.domain.model.account.Account;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
@Slf4j
public class AccountController {

    private final AccountCreator accountCreator;
    private final AccountRetrieval accountRetrieval;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestParam (name = "userId") Long userId){
        accountCreator.addAccount(userId);
    }

    @GetMapping(path = "/{accountId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountDTO findAccountById (@PathVariable Long accountId){
        Account account=accountRetrieval.findById(accountId);
        log.info(account.getAccountNumber() + " " + account.getAmount());
        return AccountMapper.mapToDTO(account);
    }
}
