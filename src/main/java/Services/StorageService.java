package Services;

import Persistence.PersistenceSessionFactory;

public class StorageService {

    public final PersistenceSessionFactory persistence;
    public StorageService(){
        persistence = new PersistenceSessionFactory();
        persistence.setUp();
    }
}
