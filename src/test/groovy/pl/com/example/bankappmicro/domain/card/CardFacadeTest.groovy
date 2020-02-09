package pl.com.example.bankappmicro.domain.card

import pl.com.example.bankappmicro.domain.account.AccountRetrieval
import pl.com.example.bankappmicro.domain.model.account.Account
import pl.com.example.bankappmicro.domain.model.card.Card
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository
import pl.com.example.bankappmicro.infrastructure.account.AccountRetrievalImpl
import pl.com.example.bankappmicro.infrastructure.card.CardCreatorImpl
import pl.com.example.bankappmicro.infrastructure.card.CardRepository
import spock.lang.Specification

class CardFacadeTest extends Specification {

    AccountRepository accountRepository=Mock(AccountRepository)
    CardRepository cardRepository=Mock(CardRepository)
    AccountRetrieval accountRetrieval=new AccountRetrievalImpl(accountRepository)
    CardCreator cardCreator=new CardCreatorImpl(accountRepository,cardRepository)

    def "Should create card in database and assign to account"(){
        given:
        Account account=createAccount
        Card card=CardCommand.generateCard("12345")
        //accountRetrieval.findById(1) >> account

        when:
        cardCreator.insertCard(account.getId(),card.getLastFourNumbers())

        then:
        println cardCreator.insertCard(account.getId(),card.getLastFourNumbers())

    }

    Account createAccount=Account.builder()
            .accountNumber("123456")
            .id(1)
            .build()
}
