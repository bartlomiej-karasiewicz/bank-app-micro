package pl.com.example.bankappmicro.domain.transfer;

import java.math.BigDecimal;

public interface TransferMoney {

    void create(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
