package pl.com.example.bankappmicro.infrastructure.account

import pl.com.example.bankappmicro.domain.account.AccountRetrieval
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException
import pl.com.example.bankappmicro.domain.model.account.Account
import spock.lang.Specification

class AccountRetrievalImplTest extends Specification {

    AccountRepository accountRepository=Mock(AccountRepository)
    AccountRetrieval accountRetrieval=new AccountRetrievalImpl(accountRepository)

    def "Verify if find user in repository"(){
        given:
        Account account=createAccount
        when:
        accountRetrieval.findById(1) >> account
        then:
        account.getId()==1
    }

    Account createAccount=Account.builder()
        .id(1)
        .accountNumber("123456")
        .build()
}
