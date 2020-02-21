package pl.com.example.bankappmicro.infrastructure.card

import pl.com.example.bankappmicro.domain.account.AccountRetrieval
import pl.com.example.bankappmicro.domain.card.CardCreator
import pl.com.example.bankappmicro.domain.model.account.Account
import pl.com.example.bankappmicro.domain.model.card.Card
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository
import pl.com.example.bankappmicro.infrastructure.account.AccountRetrievalImpl
import spock.lang.Specification

class CardCreatorImplTest extends Specification {

    AccountRepository accountRepository=Mock(AccountRepository)
    CardRepository cardRepository=Mock(CardRepository)
    AccountRetrieval accountRetrieval=new AccountRetrievalImpl(accountRepository)
    CardCreator addCard=new CardCreatorImpl(cardRepository as AccountRepository, accountRepository as CardRepository)

    def "Should create card in database and assign to account"(){
        given:
        Account account=createAccount
        when:
        accountRetrieval.findById(1) >> account
        then:
        account.getAccountNumber()=="123456"

    }

    Account createAccount=Account.builder()
            .accountNumber("123456")
            .build()
}
