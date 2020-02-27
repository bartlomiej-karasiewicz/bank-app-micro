package pl.com.example.bankappmicro.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.model.user.User;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreator userCreatorFacade;
    private final UserRetrieval userRetrieval;

    public void addUser(UserCommand userCommand){
        userCreatorFacade.addUser(userCommand);
    }

    public User findUserById(Long userId){
        return userRetrieval.findUserById(userId);
    }
}
