package pl.sda.poznan.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    //lista obserwatorów
    private List<Observer<T>> observers = new ArrayList<>();
    //metoda dodająca nowego obserwatora
    public void subscribe(Observer<T> observer){
        this.observers.add(observer);
    }
    //metoda powadamijąca wszystkich obserwatorów po kolei o wydarzeniu
    protected void propertyChanged(PropertyChangedEventArgs<T> eventArgs){
        for(Observer<T> o : observers){
            o.handle(eventArgs);
        }
    }
}
