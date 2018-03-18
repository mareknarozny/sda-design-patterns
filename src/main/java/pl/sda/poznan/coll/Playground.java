package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Playground {
    public static void main(String[] args) {
        Person student = new Person("Jan", "Kowalski", 20);
        Person kierownik = new Person("Adam", "Nowak", 25);
        Person dyrektor = new Person("Alina", "Adamiak", 30);

        List<Person> people = Arrays.asList(student, kierownik, dyrektor);
        //sortowanie z uzyciem Collection.sot
        Collections.sort(people);

        //sortowanie z użyciem Comparator
       people.sort(new Comparator<Person>() { //klasa anonimowa
           @Override
           public int compare(Person o1, Person o2) {
               return o1.getName().compareTo(o2.getName());
           }
       });

       people.sort((person1, person2)->person1.getName().compareTo(person2.getName()));

       people.stream()
               .filter(p->p.getAge()>22)
               .filter(p->p.getName().startsWith("A"))
               //.map(p->p.getSurname())
               .collect(Collectors.toList());

       people.stream()
               .map(Person::getSurname);
    }

}
