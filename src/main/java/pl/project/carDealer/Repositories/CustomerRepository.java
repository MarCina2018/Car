package pl.project.carDealer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carDealer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
