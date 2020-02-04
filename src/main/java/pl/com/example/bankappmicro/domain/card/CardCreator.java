package pl.com.example.bankappmicro.domain.card;


public interface CardCreator {

    void insertCard(Long accountId, String lastFourNumbers);

}
