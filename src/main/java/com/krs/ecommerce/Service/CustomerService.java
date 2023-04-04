package com.krs.ecommerce.Service;

import com.krs.ecommerce.Model.Customer;
import com.krs.ecommerce.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> existsCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public long countCustomers() {
        return customerRepository.count();
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
