package pl.com.example.bankappmicro.domain.model.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.com.example.bankappmicro.domain.model.card.Card;
import pl.com.example.bankappmicro.domain.model.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@AllArgsConstructor (access = AccessLevel.PACKAGE)
@Builder
@Setter
@Getter
@Table(name = "account")
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal amount;

    @OneToOne(mappedBy = "account")
    private Card card;

    public void setCard(Card card){
        card.setAccount(this);
        this.card=card;
    }
    private BigDecimal accountBalance;

    public void sendMoney(BigDecimal amount) {
        if (this.accountBalance.compareTo(amount) > 0) {
            setAccountBalance(this.accountBalance.subtract(amount));
        }
    }

    public void receiveMoney (BigDecimal amount){
        setAccountBalance(this.accountBalance.add(amount));
    }
}
