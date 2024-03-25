package Services;

import Entities.AbstractDepartment;
import Persistence.DepartmentPersistence;
import Persistence.DepartmentResponse;

import java.util.List;

public class DepartmentService {
    public final StorageService storageSession;
    public DepartmentService(StorageService storageService) {
        storageSession = storageService;
    }

    public DepartmentResponseService create (String name ) {
        return new DepartmentResponseService(DepartmentPersistence.create(name, storageSession));
    }

    public List<DepartmentResponseService> getAll () {
        var result = DepartmentPersistence.getAll(storageSession);
        DepartmentResponseService response[] = new DepartmentResponseService[result.size()];
        int i = 0;

        for (var department : result) {
            response[i] = new DepartmentResponseService(department);
            i++;
        }

        return List.of(response);
    }
}
