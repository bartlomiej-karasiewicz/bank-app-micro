package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.transfer.TransferMoney;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferMoneyImpl implements TransferMoney {

    private final AccountRepository accountRepository;

    @Override
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).get();
        Account toAccount = accountRepository.findById(toAccountId).get();

        BigDecimal subtractAmounts = fromAccount
                .getAmount()
                .subtract(amount);

        BigDecimal addAmounts = toAccount
                .getAmount()
                .add(amount);

        accountRepository.save(Account.builder()
                .accountNumber(fromAccount.getAccountNumber())
                .user(fromAccount.getUser())
                .amount(subtractAmounts)
                .id(fromAccount.getId())
                .build());

        accountRepository.save(Account.builder()
                .accountNumber(toAccount.getAccountNumber())
                .user(toAccount.getUser())
                .amount(addAmounts)
                .id(toAccount.getId())
                .build());
    }
}
