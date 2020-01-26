package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.transfer.CreateTransfer;
import pl.com.example.bankappmicro.domain.transfer.TransferMoney;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferFacade {

    private final TransferMoney transferMoney;
    private final CreateTransfer createTransfer;

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount){
        transferMoney.transferMoney(fromAccountId, toAccountId, amount);
        createTransfer.createTransfer(fromAccountId, toAccountId, amount);
    }

}
