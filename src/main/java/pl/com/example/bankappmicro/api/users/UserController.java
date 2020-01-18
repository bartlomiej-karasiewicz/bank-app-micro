package pl.com.example.bankappmicro.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.users.UserBuilder;
import pl.com.example.bankappmicro.domain.users.UserCreator;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {

    private final UserCreator createUser;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createUser(@RequestBody UserBuilder userBuilder){
        createUser.addUser(userBuilder);
    }
}
