package pl.com.example.bankappmicro.domain.user

import pl.com.example.bankappmicro.domain.exception.UserNotFoundException
import pl.com.example.bankappmicro.domain.model.user.Gender
import pl.com.example.bankappmicro.domain.model.user.User
import pl.com.example.bankappmicro.infrastructure.user.UserCreatorImpl
import pl.com.example.bankappmicro.infrastructure.user.UserRepository
import pl.com.example.bankappmicro.infrastructure.user.UserRetrievalImpl
import spock.lang.Specification

class UserFacadeTest extends Specification {

    UserRepository userRepository = Mock(UserRepository)
    UserCreator userCreatorFacade = new UserCreatorImpl(userRepository)
    UserRetrieval userRetrievalFacade = new UserRetrievalImpl(userRepository)
    UserFacade userFacade = new UserFacade(userCreatorFacade, userRetrievalFacade)

    def "Verify if user is available in database"() {
        given:
        User user=createUser
        when:
        0*userFacade.findUserById(1)>>user
        then:
        user.getUserId()==1
    }

    def "Should throw exception when user is not available"() {
        given:
        User user=createUser
        when:
        0*userFacade.findUserById(2)>> UserNotFoundException
        then:
        user.getUserId()==1
    }

    User createUser = User.builder()
            .gender(Gender.MALE)
            .login("1234")
            .userId(1)
            .build()
}
