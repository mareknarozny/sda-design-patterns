package pl.sda.poznan.observer;

//klasa Stock jest obesrwowalna (dająca się obserwwać)
public class Stock extends Observable<Stock> {
    private String name;
    //pola ne zmianę którego chcemy reagować - patrz setter
    private double price;



    public double getPrice() {
        return price;
    }

    public void set(double price) {
        if(this.price==price){
            return;
        }
        double oldPrice = this.price;
        this.price = price;
        propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
    }

    public void setPrice(double price) {
        //zmienna pomocnicza do przechowania starej ceny (sprzed wywolaia setera)
        double oldPrice = this.price;
        //jeżeli nowa cena argumentu setera równa się stara cena to nie powiadamiamy
        if(price == oldPrice){
            return;
        }
        //teraz this.price przechowuje nową wartość podaną jako argument setera
        //jeżeli ceny się zmieniły to ustawiamy nową wartośc i powiadamiamy obserwatoró
        this.price = price;
        propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
    }

    public void setPriceWithValidation (double price){
        double oldPrice = this.price;
        this.price = price;
        if(oldPrice != this.price){
            propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
