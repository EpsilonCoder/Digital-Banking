package com.epsilon.banking.entities;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Long id;
	private String name;
	private String email;
	private List<BankAccount> bankAccounts;

}
