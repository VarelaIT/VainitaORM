package Entities;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(nullable = false)
    public String name;

    public Department(){}

    public Department(String dName){
        name = dName;
    }

    public Department(String dName, int dId){
        name = dName;
        id = dId;
    }

}
