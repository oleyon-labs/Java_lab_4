package foreignNames;

import java.util.Dictionary;
import java.util.Hashtable;

public class DepartmentProvider {
    Dictionary<String, Department> departmentDictionary;
    int currentId;
    public DepartmentProvider(){
        departmentDictionary = new Hashtable<>();
        currentId=0;
    }

    public Department provide(String name){
        Department department = departmentDictionary.get(name);
        if(department == null){
            department = new Department(currentId++,name);
            departmentDictionary.put(name, department);
        }
        return department;
    }

}
