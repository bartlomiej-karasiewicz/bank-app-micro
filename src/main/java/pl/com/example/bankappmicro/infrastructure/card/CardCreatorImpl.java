package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.example.bankappmicro.domain.card.CardCommand;
import pl.com.example.bankappmicro.domain.card.CardCreator;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
import pl.com.example.bankappmicro.domain.model.account.Account;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.infrastructure.account.AccountRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardCreatorImpl implements CardCreator {

    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public void insertCard(Long accountId, String lastFourNumbers) {
        Account account=accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Account not exist with this id.")
        );
        log.info("Found account " + account);
        account.setCard(new Card());
        cardRepository.save(CardCommand.generateCard(lastFourNumbers));
    }
}
