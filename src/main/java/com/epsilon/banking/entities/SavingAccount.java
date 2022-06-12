package com.epsilon.banking.entities;



import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@DiscriminatorValue("SA") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends BankAccount {

	private double interestRate;
}
