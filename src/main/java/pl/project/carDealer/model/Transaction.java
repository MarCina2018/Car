package pl.project.carDealer.model;

import pl.project.carDealer.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Transaction {
    public Transaction() {
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date data;
    @Column
    private Double kwota;

    @Enumerated
    @Column
    private TransactionType  transactionType;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "customer_id")
    private Customer customer;
/*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "car_id")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "trade_id")
    private Trader trade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne
    // @JoinColumn (name = "invoice")
    private Invoice invoice;
*/
}
