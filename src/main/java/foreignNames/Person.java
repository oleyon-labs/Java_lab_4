package foreignNames;

import java.time.LocalDate;

public class Person {
    int id;
    String name;
    String sex;
    Department department;
    int salary;
    LocalDate birthDate;
    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
