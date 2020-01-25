package pl.com.example.bankappmicro.api.card;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CardDTO {

    @NotBlank
    @Size(min = 4, max = 4)
    private String lastFourNumbers;
}
