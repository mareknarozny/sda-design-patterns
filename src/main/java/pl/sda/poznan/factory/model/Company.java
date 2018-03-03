package pl.sda.poznan.factory.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Company {
    private String name;
    private List<Employee> empolyees = new ArrayList<>();

    public List<Employee> getEmpolyees(){
        return empolyees;
    }

    public void addEmployees(Employee e){
        this.empolyees.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmpolyees(List<Employee> empolyees) {
        this.empolyees = empolyees;
    }
}
