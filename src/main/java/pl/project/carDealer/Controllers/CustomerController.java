package pl.project.carDealer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.carDealer.Repositories.CustomerRepository;
import pl.project.carDealer.excepction.WrongObjectException;
import pl.project.carDealer.model.Customer;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    /**
     * Konstruktor z wstrzykniętym repozytorium
     *
     * @param customerRepository
     */
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Pokazuje listę dostępnych klientów
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String showList(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    /**
     * Edytuje klienta o podanym id w parametrze
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}/edit")
    public String showEditCustomer(@PathVariable("id") Integer id, Model model) {
        Customer databaseCustomer = customerRepository
                .findById(id).orElseThrow(() -> new WrongObjectException("Nie ma takiego klienta")); //rzucamy wyjątek, gdy nie ma takiego uzytkownika

        model.addAttribute("customer", databaseCustomer);
        return "customer/edit";
    }

    @GetMapping("/add")
    public String showAddNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customer/list";
    }
}


