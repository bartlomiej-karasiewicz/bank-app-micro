package pl.com.example.bankappmicro.infrastructure.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.model.transfer.Transfer;
import pl.com.example.bankappmicro.domain.transfer.CreateTransfer;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateTransferImpl implements CreateTransfer {

    private final TransferRepository transferRepository;

    @Override
    public void createTransfer(Long fromAccountId, Long toAccountId, BigDecimal amount){
        transferRepository.save(Transfer.builder()
                .fromAccountId(fromAccountId)
                .toAccountId(toAccountId)
                .pay(amount)
                .build());

    }

}
