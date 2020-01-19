package pl.com.example.bankappmicro.api.account;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class AccountDTO {

    @NotNull
    private Long accountId;
}
