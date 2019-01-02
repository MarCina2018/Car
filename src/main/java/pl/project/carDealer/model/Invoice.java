package pl.project.carDealer.model;

import javax.persistence.OneToOne;

public class Invoice {

    private Iterable nr_Faktury;

    @OneToOne(mappedBy = "invoice")
    private Transaction transaction;

}
