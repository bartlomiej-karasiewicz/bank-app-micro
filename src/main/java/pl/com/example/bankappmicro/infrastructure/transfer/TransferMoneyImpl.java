package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.api.transfer.TransferDTO;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.transfer.Transfer;
import pl.com.example.bankappmicro.domain.transfer.TransferMoney;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferMoneyImpl implements TransferMoney {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Transactional
    @Override
    public void createTransfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Not found account " + fromAccountId));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Not found account " + toAccountId));
        Transfer transfer = Transfer.builder()
                .fromAccountId(fromAccountId)
                .toAccountId(toAccountId)
                .amount(amount).build();
        fromAccount.sendMoney(amount);
        toAccount.receiveMoney(amount);
        transferRepository.save(transfer);
    }

    @Override
    @Transactional
    public void createMultiTransfers(List<TransferDTO> transferDTOList) {
        List<Transfer> listOfTransfer = new ArrayList<>();
        Account fromAccount;
        Account toAccount;
        Transfer transfer;

        for (int i = 0; i < transferDTOList.size(); i++) {
            transfer = Transfer.builder()
                    .fromAccountId(transferDTOList.get(i).getFromAccountId())
                    .toAccountId(transferDTOList.get(i).getToAccountId())
                    .amount(transferDTOList.get(i).getAmount()).build();
            fromAccount = accountRepository.findById(transfer.getFromAccountId())
                    .orElseThrow(() -> new AccountNotFoundException("Not found account"));
            toAccount = accountRepository.findById(transfer.getToAccountId())
                    .orElseThrow(() -> new AccountNotFoundException("Not found account"));
            fromAccount.sendMoney(transfer.getAmount());
            toAccount.receiveMoney(transfer.getAmount());
            transferRepository.save(transfer);
            listOfTransfer.add(transfer);
        }

    }
}
