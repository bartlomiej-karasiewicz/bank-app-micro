package pl.com.example.bankappmicro.domain.account;

import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.user.User;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Component
public class AccountGenerator {

    public Account generateAccount(User user){
        return Account.builder()
                .accountNumber(AccountGenerator.generateAccountNumber())
                .amount(BigDecimal.ZERO)
                .user(user)
                .build();
    }

    private static String generateAccountNumber(){
        return UUID.randomUUID()
                .toString()
                .substring(0,15);
    }
}
