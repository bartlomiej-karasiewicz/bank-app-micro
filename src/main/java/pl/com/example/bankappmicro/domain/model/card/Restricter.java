package pl.com.example.bankappmicro.domain.model.card;

public class Restricter {

    private static Status status;

    public static void restrict(Card card) {
        status = Status.RESTRICTED;
    }
}
