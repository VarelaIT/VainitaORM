package Persistence;

import Entities.Department;
import Services.DepartmentResponseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentPersistence{

    private final PersistenceSessionFactory persistence;
    public DepartmentPersistence(){
        persistence = new PersistenceSessionFactory();
        persistence.setUp();
    }
    public DepartmentResponseService create (String name){

        Department newDpmnt = new Department(name);

        try(Session session = persistence.sessionFactory.openSession()) {
            Transaction algo = session.getTransaction();
            algo.begin();
            session.persist(newDpmnt);
            algo.commit();
        }

        return new DepartmentResponseService(newDpmnt);
    }
}
