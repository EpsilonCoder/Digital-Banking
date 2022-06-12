package com.epsilon.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epsilon.banking.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
