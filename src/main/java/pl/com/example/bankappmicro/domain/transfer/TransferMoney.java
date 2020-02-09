package pl.com.example.bankappmicro.domain.transfer;

import pl.com.example.bankappmicro.api.transfer.TransferDTO;

import java.math.BigDecimal;
import java.util.List;

public interface TransferMoney {

    void createTransfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
    void createMultiTransfers(List<TransferDTO> transferDTOList);
}
