package com.ole.foreignNames;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Парсит данные из потока в список person
 */
public class PersonParser {
    /**
     * Парсит поток в список объектов Person
     * @param stream поток, представляющий собой таблицу
     * @param departmentProvider Провайдер подразделений
     * @return список объектов Person
     */
    public static List<Person> parseFromStream(InputStream stream, DepartmentProvider departmentProvider) {
        List<Person> people;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        try (CSVReader reader = new CSVReaderBuilder(
                new InputStreamReader(stream))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            people = new CsvToBeanBuilder<Person>(reader)
                    .withMappingStrategy(new PersonMappingStrategy(departmentProvider))
                    .withType(Person.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            people = new ArrayList<>();
        }
        return people;
    }
}
