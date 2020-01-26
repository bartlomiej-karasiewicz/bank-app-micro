package pl.com.example.bankappmicro.infrastructure.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.example.bankappmicro.domain.model.transfer.Transfer;

interface TransferRepository extends JpaRepository<Transfer, Long> {
}
