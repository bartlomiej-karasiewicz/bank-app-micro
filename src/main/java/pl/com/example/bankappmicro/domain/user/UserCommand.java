package pl.com.example.bankappmicro.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.com.example.bankappmicro.domain.model.user.Gender;
import pl.com.example.bankappmicro.domain.model.user.User;

@Builder
@Getter
@ToString
public class UserCommand {

    private String login;
    private Gender gender;

    public User generateUser(){
        return User.builder()
                .login(login)
                .gender(gender)
                .build();
    }
}
