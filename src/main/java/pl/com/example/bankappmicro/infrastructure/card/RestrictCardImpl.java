package pl.com.example.bankappmicro.infrastructure.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.example.bankappmicro.domain.card.RestrictCard;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class RestrictCardImpl implements RestrictCard {

    private final CardRepository cardRepository;

    @Override
    @Transactional
    public void restrictCard(Long accountId) {
        cardRepository.findByAccountId(accountId)
                .stream()
                .findFirst()
                .get()
                .restrict();
    }
}
