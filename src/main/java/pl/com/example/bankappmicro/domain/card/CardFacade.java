package pl.com.example.bankappmicro.domain.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardFacade {

    private final CardCreator cardCreatorFacade;
    private final RestrictCard restrictCardFacade;

    public void insertCard(Long accountId, String lastFourNumbers) {
        cardCreatorFacade.insertCard(accountId,lastFourNumbers);
    }

    public void restrictCard(Long accountId) {
        restrictCardFacade.restrictCard(accountId);
    }

}
