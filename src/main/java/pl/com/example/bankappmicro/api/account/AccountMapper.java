package pl.com.example.bankappmicro.api.account;

import pl.com.example.bankappmicro.domain.model.account.Account;

public class AccountMapper {

    static AccountDTO mapToDTO(Account account){
        return AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getAmount())
                .build();
    }
}
