package com.epsilon.banking.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@DiscriminatorValue("CUR")
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends BankAccount {

	private double overDrafs;
}
  