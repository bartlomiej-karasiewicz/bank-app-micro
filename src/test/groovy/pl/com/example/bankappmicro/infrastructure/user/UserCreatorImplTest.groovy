package pl.com.example.bankappmicro.infrastructure.user


import pl.com.example.bankappmicro.domain.model.user.Gender
import pl.com.example.bankappmicro.domain.user.UserCommand
import pl.com.example.bankappmicro.domain.user.UserCreator
import spock.lang.Specification

class UserCreatorImplTest extends Specification {

    UserRepository userRepository=Mock(UserRepository)
    UserCreator userCreator=new UserCreatorImpl(userRepository)

    def "Should save user in database"(){
        given:
        UserCommand userCommand = UserCommand.builder()
                .login("1234")
                .gender(Gender.MALE)
                .build()
        when:
        userCreator.addUser(userCommand) >> userCommand
        then:
        userCommand.getLogin()=="1234"
    }
}
