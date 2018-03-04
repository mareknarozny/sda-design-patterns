package pl.sda.poznan.singleton;


import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumDemo {
    public static void main(String[] args) {
        CompanyWriter writer = EnumFActory.INSTANCE.create("enum.xml");
        Employee dyrektor = new Employee("Jan", "Nowak", "nowak@gmail", 10000);
        Employee kierownik = new Employee("Jan", "KOwalski", "kowalski@gmail", 8000);

        Company company = new Company();
        company.addEmployees(dyrektor);
        company.addEmployees(kierownik);

        Class<? extends EnumFActory> aClass = EnumFActory.INSTANCE.getClass();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            c.setAccessible(true);
        }
        Constructor<?> declaredConstructor = declaredConstructors[0];
        try{
            Object o = declaredConstructor.newInstance();

        }catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        writer.write(company);

    }
}
