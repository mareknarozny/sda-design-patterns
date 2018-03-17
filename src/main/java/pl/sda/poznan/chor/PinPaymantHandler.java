package pl.sda.poznan.chor;

import java.util.Scanner;

public class PinPaymantHandler extends PaymentHandler {


    private static final int MAX_PRICE_TO_HANDLE = 500;

    @Override
    protected void handle(BankAccount account, double amountToPAy) {
        System.out.println("Płatnośc uwierzytelniana PINem ...");
        //pobieramy pin
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj pin ");
        String pin = scanner.next();
        //walidacja pin
        if (pin.equals(account.getPin())) {
            System.out.println("Przetwarzanie ...");
            account.setAmount(account.getAmount() - amountToPAy);
        } else {
            throw new IllegalStateException("Invalid pin");
        }
    }

    @Override
    protected double getMaxPrice() {
        return MAX_PRICE_TO_HANDLE;
    }
}
