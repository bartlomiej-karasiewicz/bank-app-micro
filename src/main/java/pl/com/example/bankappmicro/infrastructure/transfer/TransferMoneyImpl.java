package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
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
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Not found account."));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Not found account."));

        BigDecimal subtractAmounts = subtractAmounts(amount, fromAccount);

        BigDecimal addAmounts = addAmounts(amount, toAccount);

        changeSaldoInAccountBuyer(fromAccount, subtractAmounts);

        changeSaldoInAccountSeller(toAccount, addAmounts);
    }

    private void changeSaldoInAccountBuyer(Account fromAccount, BigDecimal subtractAmounts) {
        accountRepository.save(Account.builder()
                .accountNumber(fromAccount.getAccountNumber())
                .user(fromAccount.getUser())
                .amount(subtractAmounts)
                .id(fromAccount.getId())
                .build());
    }

    private void changeSaldoInAccountSeller(Account toAccount, BigDecimal addAmounts) {
        accountRepository.save(Account.builder()
                .accountNumber(toAccount.getAccountNumber())
                .user(toAccount.getUser())
                .amount(addAmounts)
                .id(toAccount.getId())
                .build());
    }

    private BigDecimal addAmounts(BigDecimal amount, Account toAccount) {
        return toAccount
                    .getAmount()
                    .add(amount);
    }

    private BigDecimal subtractAmounts(BigDecimal amount, Account fromAccount) {
        return fromAccount
                    .getAmount()
                    .subtract(amount);
    }
}
