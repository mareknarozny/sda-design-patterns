package pl.sda.poznan.chor;

public class Program {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("PKO dla młodych", 4000);
        bankAccount.setPin("1234");

        //utworzenie Handlerów i ustawienie w kolejności
        PaypassPaymentHandler paypassPaymentHandler = new PaypassPaymentHandler();
        PinPaymantHandler pinPaymantHandler = new PinPaymantHandler();
        paypassPaymentHandler.setNextHandler(pinPaymantHandler);

        //proba przetworzenia zadania - zlecamy zadanie handlerowi stojącemu najniżej w hierarchii
        paypassPaymentHandler.processPayment(bankAccount, 70);

    }
}
