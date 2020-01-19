package pl.com.example.bankappmicro.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.model.users.User;
import pl.com.example.bankappmicro.domain.users.UserBuilder;
import pl.com.example.bankappmicro.domain.users.UserCreator;
import pl.com.example.bankappmicro.domain.users.UserRetrieval;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {

    private final UserCreator userCreator;
    private final UserRetrieval userRetrieval;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserDTO userDTO){
        UserBuilder userBuilder=UserBuilder.builder()
                .login(userDTO.getLogin())
                .gender(userDTO.getGender())
                .build();
        userCreator.addUser(userBuilder);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User findUserById(@RequestParam (name = "userId") long userId){
        return userRetrieval.findUserById(userId);
    }
}
