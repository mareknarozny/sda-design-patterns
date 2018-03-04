package pl.sda.poznan.observer;



public class StockObserver implements Observer<Stock> {

    private Stock stockToObserve;

    public StockObserver(Stock stockToObserve) {
        this.stockToObserve = stockToObserve;
        this.stockToObserve.subscribe(this);
    }

    @Override
    public void handle(PropertyChangedEventArgs<Stock> args) {
        //tutaj logika przetwarzania zdarzenia np. wysylanie maila powiadamiającego
        System.out.println("Wartość się zmieniła: "+ args.getPropertyName());
        System.out.println("Stara wartość: "+ args.getOldValue());
        System.out.println("Nowa wartość: "+ args.getNewValue());
    }
}
