package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.card.CardCommand;
import pl.com.example.bankappmicro.domain.card.CardCreator;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

@Service
@RequiredArgsConstructor
class CardCreatorImpl implements CardCreator {

    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public void insertCard(Long accountId, String lastFourNumbers) {
        Account account=accountRepository.getOne(accountId);
        account.setCard(new Card());
        cardRepository.save(CardCommand.generateCard(lastFourNumbers));
    }
}
