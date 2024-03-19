package Services;

import Persistence.DepartmentPersistence;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentService {
    public final StorageService storageSession;
    public DepartmentService(StorageService storageService) {
        storageSession = storageService;
    }

    public DepartmentResponseService create (String name ) {
        return DepartmentPersistence.create(name, storageSession);
    }

    public List<DepartmentResponseService> getAll () {
        return DepartmentPersistence.getAll(storageSession);
    }
}
