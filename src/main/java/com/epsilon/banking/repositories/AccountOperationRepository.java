package com.epsilon.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epsilon.banking.entities.AccountOperation;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long > {

}
