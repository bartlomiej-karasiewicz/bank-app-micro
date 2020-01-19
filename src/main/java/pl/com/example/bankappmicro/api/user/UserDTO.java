package pl.com.example.bankappmicro.api.user;

import lombok.Builder;
import lombok.Value;
import pl.com.example.bankappmicro.domain.model.user.Gender;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class UserDTO {

    @NotNull @Min(6)
    private String login;

    @NotNull
    private Gender gender;
}
