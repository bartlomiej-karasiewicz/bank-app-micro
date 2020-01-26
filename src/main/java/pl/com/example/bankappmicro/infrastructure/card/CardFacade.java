package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.com.example.bankappmicro.domain.card.CardCommand;
import pl.com.example.bankappmicro.domain.model.card.Card;

@Component
@RequiredArgsConstructor
public class CardFacade {

    private final CardCreatorImpl cardCreatorFacade;
    private final RestrictCardImpl restrictCardFacade;

    public void insertCard(Long accountId, String lastFourNumbers) {
        cardCreatorFacade.insertCard(accountId,lastFourNumbers);
    }

    public void restrictCard(Long accountId) {
        restrictCardFacade.restrictCard(accountId);
    }

}
