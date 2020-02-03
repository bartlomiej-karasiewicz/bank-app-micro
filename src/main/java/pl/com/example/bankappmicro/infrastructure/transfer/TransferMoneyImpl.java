package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.transfer.Transfer;
import pl.com.example.bankappmicro.domain.transfer.TransferMoney;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferMoneyImpl implements TransferMoney {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Transactional
    @Override
    public void create(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(()->new AccountNotFoundException("Not found account " + fromAccountId));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(()->new AccountNotFoundException("Not found account " + toAccountId));
        Transfer transfer = Transfer.builder()
                .fromAccountId(fromAccountId)
                .toAccountId(toAccountId)
                .amount(amount).build();
        fromAccount.sendMoney(amount);
        toAccount.receiveMoney(amount);
        transferRepository.save(transfer);
    }
}
