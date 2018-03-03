package pl.sda.poznan.factory.writer;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TxtCompanyWriter implements CompanyWriter {
    private final String path;

    public TxtCompanyWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(Company company) {
        //podejście iteratywne
        List<String> strings = new ArrayList<>();
        for(Employee employee:company.getEmpolyees()){
            strings.add(employee.toString());
        }
        //podejście deklaratywne /funkcyjne  - od Java 8
        List<String> collect = company.getEmpolyees()
                .stream()
//                .map(e->e.toString())
                .map(Employee::toString)
                .collect(Collectors.toList());
        try {
            //metoda write przyjmuje scieżkę do pliku i Iterable<? exends CharSequence>
            //drugi zapis oznacza że możemy tutaj podać listę ale tylko taką
            //która przechowuje typ dziedziczony poa CharSequence np. String
            Files.write(Paths.get(path),strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
