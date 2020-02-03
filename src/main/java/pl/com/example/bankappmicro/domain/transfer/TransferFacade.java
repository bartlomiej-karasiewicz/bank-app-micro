package pl.com.example.bankappmicro.domain.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferFacade {

    private final TransferMoney transferMoney;

    public void createTransfer(Long fromAccountNumber, Long toAccountNumber, BigDecimal amount) {
        transferMoney.create(fromAccountNumber,toAccountNumber, amount);
    }


}
