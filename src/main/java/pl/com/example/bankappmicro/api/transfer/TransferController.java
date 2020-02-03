package pl.com.example.bankappmicro.api.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.example.bankappmicro.domain.transfer.TransferFacade;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/transfers")
public class TransferController {

    private final TransferFacade transferFacade;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void transfer(@RequestBody TransferDTO transferDTO){
        transferFacade.createTransfer(transferDTO.getFromAccountId(),transferDTO.getToAccountId(),transferDTO.getAmount());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/list")
    public void transfer(@RequestBody List<TransferDTO> transferDTOList){
        transferFacade.createTransfers(transferDTOList);
    }
}
