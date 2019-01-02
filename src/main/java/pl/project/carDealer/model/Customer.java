package pl.project.carDealer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {


    public Customer() {
    }


    //    private Integer id;
//    private Integer nr_klienta;
//    private String nazwisko;
//    private String imię;
//    private String adres;
//    private String nNIP;
//    private String pesel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer customer_number;
    @Column
    private String last_name;
    @Column
    private String first_name;
    @Column
    private String address;
    @Column
    private String nNIP;
    @Column
    private String pesel;



    public Customer (Integer customer_number,String last_name, String first_name,
                     String addres, String nNIP, String pesel ){
        this.customer_number = customer_number;
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = addres;
        this.nNIP = nNIP;
        this.pesel = pesel;

    }



    @JsonIgnore
    @OneToMany (mappedBy = "customer")
    private Set<Car> cars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(Integer customer_number) {
        this.customer_number = customer_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getnNIP() {
        return nNIP;
    }

    public void setnNIP(String nNIP) {
        this.nNIP = nNIP;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
