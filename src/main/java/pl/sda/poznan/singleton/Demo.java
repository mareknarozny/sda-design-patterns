package pl.sda.poznan.singleton;

public class Demo {
    public static void main(String[] args) {
        //Prywatny konstruktor  - brak możliwości tworzenia obiektów
//        SingleCompanyWriterFactory factory = new SingleCompanyWriterFactory();
        SingleCompanyWriterFactory instance = SingleCompanyWriterFactory.getInstance();
        SingleCompanyWriterFactory companyWriterFactory = SingleCompanyWriterFactory.getInstance();

        if (instance == companyWriterFactory) {
            System.out.println("Ten sam obiekt");
        } else {
            System.out.println("Inny obiekt");
        }
    }
}
