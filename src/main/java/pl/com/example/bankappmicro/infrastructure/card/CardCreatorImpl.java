package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.card.CardCommand;
import pl.com.example.bankappmicro.domain.card.CardCreator;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

@Service
@RequiredArgsConstructor
class CardCreatorImpl implements CardCreator {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    @Override
    public void insertCard(Long accountId, CardCommand cardCommand) {
        Account account=accountRepository.getOne(accountId);
        account.setCard(new Card());
    }
}
