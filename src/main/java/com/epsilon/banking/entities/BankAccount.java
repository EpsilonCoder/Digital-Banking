package com.epsilon.banking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.epsilon.banking.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Type",length = 4,discriminatorType = DiscriminatorType.STRING)
public class BankAccount {
	@Id
	private String id;
	private double balance;
	private Date createAt;
	@Enumerated(EnumType.STRING)
	private AccountStatus status; 
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "bankAccount")
	private List<AccountOperation> accountOperations;
	

}
