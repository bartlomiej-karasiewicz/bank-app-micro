package pl.com.example.bankappmicro.domain.users;

import lombok.Builder;
import lombok.Getter;
import pl.com.example.bankappmicro.domain.model.users.Gender;
import pl.com.example.bankappmicro.domain.model.users.User;

@Builder
@Getter
public class UserBuilder {

    private String login;
    private Gender gender;

    public User generateUser(){
        return User.builder()
                .login(login)
                .gender(gender)
                .build();
    }
}
