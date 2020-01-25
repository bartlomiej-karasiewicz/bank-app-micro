package pl.com.example.bankappmicro.domain.card;


import lombok.Builder;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.domain.model.card.Status;

@Builder
public class CardCommand {

    private String lastFourNumbers;
    private Status status;

    public Card insertCard(Account account){
        return Card.builder()
                .lastFourNumber(lastFourNumbers)
                .status(Status.ACTIVE)
                .account(account)
                .build();
    }
}
