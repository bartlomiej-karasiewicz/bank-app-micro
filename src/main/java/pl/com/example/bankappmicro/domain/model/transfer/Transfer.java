package pl.com.example.bankappmicro.domain.model.transfer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal pay;
}
