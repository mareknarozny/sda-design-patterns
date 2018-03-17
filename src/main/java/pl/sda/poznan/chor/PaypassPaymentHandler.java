package pl.sda.poznan.chor;


//[łatność zbliżeniowa - max kwota 50 zł
public class PaypassPaymentHandler extends PaymentHandler {


    private static final int MAX_PRICE_TO_HANDLE = 50;

    @Override
    protected void handle(BankAccount account, double amountToPay) {
        System.out.println("Płatność zbliżeniowa jest realizowana");
        account.setAmount(account.getAmount() - amountToPay);
        System.out.println("Zapłacono zbliżeniowo");
    }

    @Override
    protected double getMaxPrice() {
        return MAX_PRICE_TO_HANDLE;
    }
}
