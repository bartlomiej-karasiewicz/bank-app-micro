package pl.com.example.bankappmicro.domain.transfer;

import java.math.BigDecimal;

public interface CreateTransfer {
    void createTransfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
