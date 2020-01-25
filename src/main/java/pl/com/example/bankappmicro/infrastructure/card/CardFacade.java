package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.com.example.bankappmicro.domain.card.CardCommand;

@Component
@RequiredArgsConstructor
public class CardFacade {

    private final CardCreatorImpl cardCreatorFacade;
    private final RestrictCardImpl restrictCardFacade;

    public void insertCard(Long accountId, CardCommand cardCommand) {
        cardCreatorFacade.insertCard(accountId,cardCommand);
    }

    public void restrictCard(Long accountId) {
        restrictCardFacade.restrictCard(accountId);
    }

}
