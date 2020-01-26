package pl.com.example.bankappmicro.api.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.infrastructure.transfer.TransferFacade;

import java.math.BigDecimal;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/transfers")
public class TransferController {

    private final TransferFacade transferFacade;

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping("/{fromAccountId}/{toAccountId}")
    public void transfer(@PathVariable Long fromAccountId,
                         @PathVariable Long toAccountId,
                         @RequestParam (name = "amount") BigDecimal amount){
        transferFacade.transfer(fromAccountId,toAccountId,amount);
    }
}
