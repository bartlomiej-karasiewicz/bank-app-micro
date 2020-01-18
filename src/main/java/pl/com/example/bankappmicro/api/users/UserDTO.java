package pl.com.example.bankappmicro.api.users;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import pl.com.example.bankappmicro.domain.model.users.Gender;

import javax.validation.constraints.Min;

@Value
@Builder
public class UserDTO {

    @NonNull @Min(6)
    private String login;

    @NonNull
    private Gender gender;
}
