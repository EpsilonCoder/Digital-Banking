package com.epsilon.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epsilon.banking.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

	
}
