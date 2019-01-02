package pl.project.carDealer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.project.carDealer.Repositories.CustomerRepository;
import pl.project.carDealer.excepction.WrongObjectException;
import pl.project.carDealer.model.Customer;

import java.util.List;

public class CustomerServices {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer get(Integer id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Brak wpisu w bazie"));
    }

    public void update(Customer customer, Customer updatedCustomer) {
        if (updatedCustomer.getId().equals(customer.getId())) {
            save(updatedCustomer);
        } else {
            throw new WrongObjectException("Id obiektów się nie zgadzają");
        }
    }

    public void save(Customer updatedCustomer) {
        customerRepository.save(updatedCustomer);
    }

    public void delete(Integer id) {
        Customer customer = get(id);
        customerRepository.deleteById(customer.getId());
    }


}
