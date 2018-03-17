package pl.sda.poznan.chor;

import java.awt.dnd.InvalidDnDOperationException;

//bazowa klasa dla Handlerów czyli obiektów umiejącch przetwarzać żądania;
//Klasy rozszerzające te klasę są elementami łańcucha zobowiązań
public abstract class PaymentHandler {

    protected PaymentHandler nextHandler;

    public void setNextHandler(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //sprawdzić czy możemy przetworzyć żądanie jeśli nie to przekazać wyżej wzdłuż łańcucha zobowiązań
    public void processPayment(BankAccount bankAccount, double amount) {
        //jeżeli dany handler umie obsłuzyć żadanie (canHandle zwraca true)
        //to wtkonuje metodę obsługi zadania
        //w przeciwnym wypadku sprawdza czy jest kolejny handler
        //jeżeli tak to przekazuje zadanie wyżej, kolejny handler znowu sprawdzi czy umie to zrobić itd
        if (canHandlePaymant(amount)) {
            handle(bankAccount, amount);
        } else if (nextHandler != null) {
            nextHandler.processPayment(bankAccount, amount);
        } else {
            throw new InvalidDnDOperationException("Nie jestem w stanie obsłużyć zadania. Kwota zbyt duża");
        }
    }

    private boolean canHandlePaymant(double amount) {
        return amount < getMaxPrice();
    }

    //abstrakcyjna metoda
    //dlatego że na tym etapie jeszcze nie wiemy jak przetwarzać płatność
    protected abstract void handle(BankAccount account, double amount);

    //MEtoda zwraca maksymalną kwotę jaką może obsłużyć dana metoda (np. 50zł dla zbliżeniowej i 500zł dla PIN)
    protected abstract double getMaxPrice();

}
