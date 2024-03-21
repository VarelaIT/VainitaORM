package Services;

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
        List<DepartmentResponse> answer = DepartmentPersistence.getAll(storageSession);
        List<DepartmentResponseService> response[]=  new DepartmentResponseService[answer.size()];


        answer.forEach(dpmnt -> {
            ((List<DepartmentResponseService>[]) response).add(new DepartmentResponseService(dpmnt));
        });

        return response;
    }
}
