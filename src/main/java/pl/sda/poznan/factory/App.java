package pl.sda.poznan.factory;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;
import pl.sda.poznan.factory.writer.TxtCompanyWriter;
import pl.sda.poznan.factory.writer.XmlCompanyWriter;

import java.util.Scanner;

public class App {

    //utwórz klasę Employee przechowujące dane o pracownikach
    // imien nazwisko, email, salary
    //utworz klasę Company
    //jak zaprezentować fakt że firma ma pracownikó
    public static void main(String[] args) {


        Employee dyrektor = new Employee("Jan", "Nowak", "nowak@gmail", 10000);
        Employee kierownik = new Employee("Jan", "KOwalski", "kowalski@gmail", 8000);

        Company company = new Company();
        company.addEmployees(dyrektor);
        company.addEmployees(kierownik);
//        CompanyWriter writer = new XmlCompanyWriter("firma.xml");
//        writer.write(company);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku do którego chcesz zapisać: ");
        String filename = scanner.next();

        CompanyWriterFactory companyWriterFactory = new CompanyWriterFactory();

        try {
            CompanyWriter writer = companyWriterFactory.create(filename);
            writer.write(company);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

