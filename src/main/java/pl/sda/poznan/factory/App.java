package pl.sda.poznan.factory;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;
import pl.sda.poznan.factory.writer.TxtCompanyWriter;
import pl.sda.poznan.factory.writer.XmlCompanyWriter;

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
        CompanyWriter writer = new XmlCompanyWriter("firma.xml");
        writer.write(company);
    }
}
