import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import foreignNames.DepartmentProvider;
import foreignNames.Person;
import foreignNames.PersonMappingStrategy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";


        /*List<Human> beans = new CsvToBeanBuilder(new InputStreamReader(Program.class.getClassLoader().getResourceAsStream(csvFilePath)))
                .withType(Human.class)
                .build()
                .parse();


        List<Human> beans1 = new CsvToBeanBuilder()
                .withType(Human.class)
                .build()
                .parse();*/


        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        //var param = new CsvToBeanBuilder<Person>(new InputStreamReader(Program.class.getClassLoader().getResourceAsStream(csvFilePath)))
        //        .withMappingStrategy(new PersonMappingStrategy(new DepartmentProvider())).build().parse();
        try(CSVReader reader = new CSVReaderBuilder(
                new InputStreamReader(Program.class.getClassLoader().getResourceAsStream(csvFilePath)))
                .withCSVParser(csvParser)   // custom CSV parser
                .withSkipLines(1)           // skip the first line, header info
                .build()){
            List<Person> beans3 = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(new PersonMappingStrategy(new DepartmentProvider()))
                    .withType(Person.class)
                    .build()
                    .parse();

            for (Person human:
                 beans3) {
                System.out.println(human);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }






        /*try (InputStream in = Program.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in))) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                //А тут работаете с nextLine котрый представляет из себя текущую строчку в файле, уже разбитую на массив по разделителю separator
                //Попробуйте просто вывести на экран этот nextLine и, думаю, все будет понятно
                System.out.println(nextLine[1]);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
