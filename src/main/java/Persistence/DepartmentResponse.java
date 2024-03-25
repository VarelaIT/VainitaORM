package Persistence;

import Entities.AbstractDepartment;
import Entities.Department;

public class DepartmentResponse extends AbstractDepartment {
    public DepartmentResponse(AbstractDepartment dpmnt){
        this.id = dpmnt.id;
        this.name = dpmnt.name;
    }
}
