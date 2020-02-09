package pl.com.example.bankappmicro.domain.model.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import pl.com.example.bankappmicro.domain.model.account.Account;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "card")
public class Card {

    @Id
    private Long cardId;

    @Length(min = 4, max = 4)
    private String lastFourNumbers;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private Account account;

    public void restrict() {
        this.status = Status.RESTRICTED;
    }
}
