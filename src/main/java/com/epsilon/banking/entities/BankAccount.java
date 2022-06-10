package com.epsilon.banking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.epsilon.banking.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
	
	private String id;
	private double balance;
	private Date createAt;
	
	//Creons ici un enumerateur 
	private AccountStatus status; 
	private Customer customer;
	private List<AccountOperation> accountOperations;
	

}
