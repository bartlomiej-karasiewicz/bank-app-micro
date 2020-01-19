package pl.com.example.bankappmicro.infrastructure.account;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.example.bankappmicro.domain.model.account.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
