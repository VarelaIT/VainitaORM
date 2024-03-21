package Persistence;

import Entities.Department;

public class DepartmentResponse extends Department{
    public DepartmentResponse(Department dpmnt){
        this.id = dpmnt.id;
        this.name = dpmnt.name;
    }
}
