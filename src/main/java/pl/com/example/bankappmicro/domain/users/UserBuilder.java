package pl.com.example.bankappmicro.domain.users;

import lombok.Builder;
import lombok.Getter;
import pl.com.example.bankappmicro.domain.model.users.Gender;
import pl.com.example.bankappmicro.domain.model.users.Users;

@Builder
@Getter
public class UserBuilder {

    private String login;
    private Gender gender;

    public Users generateUser(){
        return Users.builder()
                .login(login)
                .gender(gender)
                .build();
    }
}
