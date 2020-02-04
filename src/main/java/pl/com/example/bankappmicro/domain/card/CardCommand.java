package pl.com.example.bankappmicro.domain.card;


import lombok.Builder;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.domain.model.card.Status;

@Builder
public class CardCommand {

    private Status status;

    public static Card generateCard(String lastFourNumbers){
        return Card.builder()
                .lastFourNumbers(lastFourNumbers)
                .status(Status.ACTIVE)
                .build();
    }
}
