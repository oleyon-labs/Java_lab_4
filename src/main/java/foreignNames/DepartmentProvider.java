package foreignNames;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Класс хранящий уникальные подразделения и возвращающая конкретное подразделение при запросе
 * Предотвращает создание одинаковых подразделений
 */
public class DepartmentProvider {
    /**
     * словарь, хранящий объекты подразделений по их названиям
     */
    private Dictionary<String, Department> departmentDictionary;
    /**
     * текущий id для следующего созданного подразделения
     */
    private int currentId;
    public DepartmentProvider(){
        departmentDictionary = new Hashtable<>();
        currentId=0;
    }

    /**
     * предоставляет объект Department при запросе по названию, всегда возвращает одинаковый объект для одинаковых названий
     * @param name название подразделения
     * @return объект подразделения
     */
    public Department provide(String name){
        Department department = departmentDictionary.get(name);
        if(department == null){
            department = new Department(currentId++,name);
            departmentDictionary.put(name, department);
        }
        return department;
    }

}
