package pl.project.carDealer.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table( name = "Employe")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;

    @Temporal( TemporalType.DATE)
    @Column
    private Date dateEmployment;

}
