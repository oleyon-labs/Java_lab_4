package foreignNames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonParserTest {

    @Test
    @DisplayName("Тест на маленьком количестве строк")
    void parseFromStream() {
        String table = """
                id;name;gender;BirtDate;Division;Salary
                28281;Aahan;Male;15.05.1970;I;4800
                28282;Aala;Female;07.02.1983;J;2600
                28283;Aaleahya;Female;06.11.1949;F;1000
                28284;Aaleyah;Female;04.02.1944;G;1000
                28285;Aalijah;Female;17.11.1951;H;2400
                28286;Aaliyah;Female;10.11.1978;G;1500
                28287;Aaliyah;Female;25.09.1987;C;1100""";
        DepartmentProvider departmentProvider = new DepartmentProvider();
        List<Person> people = PersonParser.parseFromStream(new ByteArrayInputStream(table.getBytes(StandardCharsets.UTF_8)), departmentProvider);
        //Проверка на одинаковые объекты подразделений
        Assertions.assertSame(departmentProvider.provide("J"), people.get(1).getDepartment());
        Assertions.assertSame(people.get(3).getDepartment(), people.get(5).getDepartment());
        Assertions.assertNotSame(people.get(3), people.get(4));
        //Проверка всех полей по 1 человеку
        Person person = people.get(4);
        Assertions.assertEquals(person.getId(), 28285);
        Assertions.assertEquals(person.getName(), "Aalijah");
        Assertions.assertEquals(person.getSex(), "Female");
        Assertions.assertEquals(person.getDepartment().getName(), "H");
        Assertions.assertEquals(person.getSalary(), 2400);
        Assertions.assertEquals(person.getBirthDate().getYear(), 1951);
        Assertions.assertEquals(person.getBirthDate().getMonth().getValue(), 11);
        Assertions.assertEquals(person.getBirthDate().getDayOfMonth(), 17);
    }
}