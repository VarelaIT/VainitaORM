package Persistence;

import Entities.Department;
import Services.DepartmentResponseService;
import Services.StorageService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentPersistence{

    public static DepartmentResponseService create (String name, StorageService storage){

        Department newDpmnt = new Department(name);

        try(Session session = storage.persistence.sessionFactory.openSession()) {
            session.getTransaction().begin();
            //Transaction algo = session.getTransaction();
            //algo.begin();
            session.persist(newDpmnt);
            //algo.commit();
            session.getTransaction().commit();
        }

        return new DepartmentResponseService(newDpmnt);
    }

    public static List<DepartmentResponseService> getAll (StorageService storage){


        try (Session session = storage.persistence.sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<Department> result = session.createQuery("from Department", Department.class).getResultList();
            session.getTransaction().commit();

            DepartmentResponseService response[] = new DepartmentResponseService[result.size()];
            int i = 0;

            for (Department department : result) {
                response[i] = new DepartmentResponseService(department);
                i++;
            }

            return List.of(response);
        }
    }
}
