package pl.com.example.bankappmicro.api.card;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.card.CardCommand;
import pl.com.example.bankappmicro.infrastructure.card.CardFacade;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardFacade cardFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/{accountId}/card")
    public void createCard(@PathVariable Long accountId,
                           @Valid @RequestBody CardDTO cardDTO){
        CardCommand cardCommand=CardCommand.builder()
                .lastFourNumbers(cardDTO.getLastFourNumbers())
                .build();
        cardFacade.insertCard(accountId, cardCommand);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("/{accountId}/card")
    public void restrictCard(@PathVariable Long accountId){
        cardFacade.restrictCard(accountId);
    }
}
