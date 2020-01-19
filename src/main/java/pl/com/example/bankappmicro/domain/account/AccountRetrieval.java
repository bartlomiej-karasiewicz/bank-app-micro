package pl.com.example.bankappmicro.domain.account;

import pl.com.example.bankappmicro.domain.model.account.Account;

public interface AccountRetrieval {

    Account findById(Long accountId);
}
