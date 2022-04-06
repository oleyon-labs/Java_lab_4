package com.ole.foreignNames;

import java.time.LocalDate;

/**
 * Класс хранения информации по человеку
 */
public class Person {
    /**
     * id
     */
    private final int id;
    /**
     * имя
     */
    private final String name;
    /**
     * пол
     */
    private final String sex;
    /**
     * подразделение, в котором работает человек
     */
    private final Department department;
    /**
     * зарплата
     */
    private final int salary;
    /**
     * дата рождения
     */
    private final LocalDate birthDate;

    public Person(int id, String name, String sex, Department department, int salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
