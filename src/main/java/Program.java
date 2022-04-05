import foreignNames.DepartmentProvider;
import foreignNames.Person;
import foreignNames.PersonParser;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        DepartmentProvider departmentProvider = new DepartmentProvider();
        List<Person> people = PersonParser.parseFromStream(Program.class.getClassLoader().getResourceAsStream(csvFilePath), departmentProvider);

        for (Person human:
                 people) {
            System.out.println(human);
        }
    }
}
