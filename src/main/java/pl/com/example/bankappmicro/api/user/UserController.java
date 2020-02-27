package pl.com.example.bankappmicro.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.model.user.User;
import pl.com.example.bankappmicro.domain.user.UserCommand;
import pl.com.example.bankappmicro.domain.user.UserFacade;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserDTO userDTO){
        UserCommand userCommand = UserCommand.builder()
                .login(userDTO.getLogin())
                .gender(userDTO.getGender())
                .build();
        userFacade.addUser(userCommand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User findUserById(@RequestParam (name = "userId") long userId){
        return userFacade.findUserById(userId);
    }
}
