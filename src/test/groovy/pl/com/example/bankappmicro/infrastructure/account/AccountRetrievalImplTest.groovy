package pl.com.example.bankappmicro.infrastructure.account

import pl.com.example.bankappmicro.domain.model.account.Account
import spock.lang.Specification

class AccountRetrievalImplTest extends Specification {

    AccountRepository accountRepository=Mock(AccountRepository)
    AccountRetrievalImpl accountRetrieval=new AccountRetrievalImpl(accountRepository)

    def "Verify if find user in repository"(){
        given:
        Account account=createAccount
        when:
        accountRetrieval.findById(1) >> account
        then:
        account.getAccountNumber()=="123456"
        println account
    }


    Account createAccount=Account.builder()
        .accountNumber("123456")
        .build()
}
