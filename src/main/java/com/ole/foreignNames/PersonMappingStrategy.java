package com.ole.foreignNames;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Устанавливает стратегию парсинга файла для opencsv
 */
public class PersonMappingStrategy extends ColumnPositionMappingStrategy {

    /**
     * провайдер подразделений
     */
    DepartmentProvider departmentProvider;

    public PersonMappingStrategy(DepartmentProvider departmentProvider) {
        this.setType(Person.class);
        this.departmentProvider = departmentProvider;
    }

    /**
     * Основной метод создания стратегии
     * @param line очередная строка таблицы
     * @return готовый объект человека
     */
    @Override
    public Object populateNewBean(String[] line) throws CsvBeanIntrospectionException {
        return new Person(Integer.parseInt(line[0]),
                line[1],
                line[2],
                departmentProvider.provide(line[4]),
                Integer.parseInt(line[5]),
                LocalDate.parse(line[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

}