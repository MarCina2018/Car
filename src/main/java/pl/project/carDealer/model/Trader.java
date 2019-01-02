package pl.project.carDealer.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

public class Trader extends Employee {

    private int nr_trader;


}
