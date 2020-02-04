package pl.com.example.bankappmicro.infrastructure.card;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.example.bankappmicro.domain.model.card.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByAccountId(Long accountId);
}
