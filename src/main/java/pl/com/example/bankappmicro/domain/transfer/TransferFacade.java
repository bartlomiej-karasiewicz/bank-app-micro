package pl.com.example.bankappmicro.domain.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.api.transfer.TransferDTO;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferFacade {

    private final TransferMoney transferMoney;

    public void createTransfer(Long fromAccountNumber, Long toAccountNumber, BigDecimal amount) {
        transferMoney.createTransfer(fromAccountNumber,toAccountNumber, amount);
    }

    public void createTransfers(List<TransferDTO> transferDTOList) {
        transferMoney.createMultiTransfers(transferDTOList);
    }
}
