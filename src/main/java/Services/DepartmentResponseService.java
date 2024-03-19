package Services;

import Entities.Department;
import Persistence.DepartmentPersistence;

public class DepartmentResponseService {
    private final int id;
    private final String name;
    public DepartmentResponseService (Department dpmnt){
        this.id = dpmnt.id;
        this.name = dpmnt.name;
    }

    public void print () {
        System.out.println(
               "\n\t{"
               + "\n\t\tid: " + this.id
               + ",\n\t\tname: \"" + this.name
               + "\"\n\t}"
        );
    }
}
