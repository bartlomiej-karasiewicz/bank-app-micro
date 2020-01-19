package pl.com.example.bankappmicro.domain.account;

import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.account.AccountNumberGenerator;
import pl.com.example.bankappmicro.domain.model.user.User;

import java.math.BigDecimal;

@Builder
@Component
public class AccountGenerator {

    public Account generateAccount(User user){
        return Account.builder()
                .accountNumber(AccountNumberGenerator.generateAccountNumber())
                .amount(BigDecimal.ZERO)
                .user(user)
                .build();
    }

}
