package pl.com.example.bankappmicro.domain.model.account;

import java.util.UUID;

public class AccountNumberGenerator {

    public static String generateAccountNumber(){
        return UUID.randomUUID()
                .toString()
                .substring(0,15);
    }

}
