package foreignNames;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonMappingStrategy extends ColumnPositionMappingStrategy {

    DepartmentProvider departmentProvider;

    public PersonMappingStrategy(DepartmentProvider departmentProvider) {
        this.setType(Person.class);
        this.departmentProvider = departmentProvider;
    }


    @Override
    public Object populateNewBean(String[] line) throws CsvBeanIntrospectionException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException, CsvConstraintViolationException, CsvValidationException {
        Person person = new Person();
        person.id = Integer.parseInt(line[0]);
        person.name = line[1];
        person.sex = line[2];
        person.birthDate = LocalDate.parse(line[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        person.department = departmentProvider.provide(line[4]);
        person.salary = Integer.parseInt(line[5]);
        return person;
    }

}