package Persistence;

import Entities.AbstractDepartment;
import Entities.Department;
import Services.StorageService;
import org.hibernate.Session;

import java.util.List;

public class DepartmentPersistence {

    public static DepartmentResponse create (String name, StorageService storage){

        AbstractDepartment newDpmnt = new Department(name);

        try (Session session = storage.persistence.sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(newDpmnt);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("\n* Error: Could not create resource. " + e.getMessage());
        }

        return new DepartmentResponse(newDpmnt);
    }


    public static List<DepartmentResponse> getAll (StorageService storage) {

        try(var session = storage.persistence.sessionFactory.openSession()){
            session.getTransaction().begin();
            List<AbstractDepartment> result = session.createQuery("from Department", AbstractDepartment.class).getResultList();
            session.getTransaction().commit();

            DepartmentResponse response[] = new DepartmentResponse[result.size()];
            int i = 0;

            for (AbstractDepartment department : result) {
                response[i] = new DepartmentResponse(department);
                i++;
            }

            return List.of(response);
        } catch (Exception e) {
            System.out.println("\n* Error: The Storage service couldn't initialized.\n\t" + e.getMessage());
            System.exit(-1);
        }

        return null;
    }
}
