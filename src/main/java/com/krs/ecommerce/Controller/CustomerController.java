package com.krs.ecommerce.Controller;

import com.krs.ecommerce.Model.Customer;
import com.krs.ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Create a new customer
    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    //GET methods
    @GetMapping()
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomer(id).orElse(null);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.existsCustomer(id);
        return new ResponseEntity<>(customer.isPresent(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCustomers() {
        long count = customerService.countCustomers();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //Updating a customer
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") Long id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerService.getCustomer(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if (updatedCustomer.getFirstName() != null) {
                customer.setFirstName(updatedCustomer.getFirstName());
            }
            if (updatedCustomer.getLastName() != null) {
                customer.setLastName(updatedCustomer.getLastName());
            }
            if (updatedCustomer.getEmail() != null) {
                customer.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getAddress() != null) {
                customer.setAddress(updatedCustomer.getAddress());
            }
            if (updatedCustomer.getCity() != null) {
                customer.setCity(updatedCustomer.getCity());
            }
            if (updatedCustomer.getState() != null) {
                customer.setState(updatedCustomer.getState());
            }
            if (updatedCustomer.getZipCode() != null) {
                customer.setZipCode(updatedCustomer.getZipCode());
            }
            if (updatedCustomer.getPhoneNumber() != null) {
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            }
            customerService.addCustomer(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Deleting a customer
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> optionalCustomer = customerService.getCustomer(id);
        if (optionalCustomer.isPresent()) {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
