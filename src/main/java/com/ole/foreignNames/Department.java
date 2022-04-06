package com.ole.foreignNames;

/**
 * Класс хранения информации по подразделению
 */
public class Department {
    /**
     * id подразделения
     */
    private final int id;
    /**
     * название подразделения
     */
    private final String name;

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * геттер названия
     * @return название подразделения
     */
    public String getName() {
        return name;
    }
}
