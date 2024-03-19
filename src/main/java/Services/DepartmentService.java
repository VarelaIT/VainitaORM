package Services;

import Entities.Department;
import Persistence.DepartmentPersistence;

public class DepartmentService {
    public DepartmentResponseService create (String name ) {
        DepartmentPersistence persistence = new DepartmentPersistence();

        return persistence.create(name);
    }
}
