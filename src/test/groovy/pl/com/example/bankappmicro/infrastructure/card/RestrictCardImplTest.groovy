package pl.com.example.bankappmicro.infrastructure.card

import pl.com.example.bankappmicro.domain.card.RestrictCard
import pl.com.example.bankappmicro.domain.model.account.Account
import pl.com.example.bankappmicro.domain.model.card.Card
import pl.com.example.bankappmicro.domain.model.card.Status
import spock.lang.Specification

class RestrictCardImplTest extends Specification {

    CardRepository cardRepository=Mock(CardRepository)
    RestrictCard restrictCardImpl=new RestrictCardImpl(cardRepository)


    def "Card should be restrict"(){
        given:
        Card card= createCard("1324")
        cardRepository.findByAccountId(1)>> [card]
        when:
        restrictCardImpl.restrictCard(1)
        then:
        card.getStatus()==Status.RESTRICTED
    }

    Card createCard(String lastFourNumbers){
        return Card.builder()
                .cardId(1)
                .lastFourNumbers(lastFourNumbers)
                .account(Account.builder().id(1).build())
                .status(Status.ACTIVE)
                .build()
    }

}
