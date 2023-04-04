package com.krs.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "customers")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String phoneNumber;

        public Customer() {
        }

        public Customer(String firstName, String lastName, String email, String password, String address, String city, String state, String zipCode, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.phoneNumber = phoneNumber;
        }


}
