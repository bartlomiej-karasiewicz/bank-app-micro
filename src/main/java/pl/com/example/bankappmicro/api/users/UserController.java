package pl.com.example.bankappmicro.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.model.users.Users;
import pl.com.example.bankappmicro.domain.users.UserBuilder;
import pl.com.example.bankappmicro.domain.users.UserCreator;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {

    private final UserCreator createUser;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createUser(@Valid @RequestBody UserBuilder userBuilder){
        UserDTO.builder()
                .login(userBuilder.getLogin())
                .gender(userBuilder.getGender())
                .build();
        createUser.addUser(userBuilder);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Users getUserById(@RequestParam (name = "userId") long userId){
        return createUser.getUserById(userId).orElseThrow(() -> new IllegalArgumentException());
    }
}
