package com.epsilon.banking;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.epsilon.banking.entities.AccountOperation;
import com.epsilon.banking.entities.CurrentAccount;
import com.epsilon.banking.entities.Customer;
import com.epsilon.banking.entities.SavingAccount;
import com.epsilon.banking.enums.AccountStatus;
import com.epsilon.banking.enums.OperationType;
import com.epsilon.banking.repositories.AccountOperationRepository;
import com.epsilon.banking.repositories.BankAccountRepository;
import com.epsilon.banking.repositories.CustomerRepository;

@SpringBootApplication
public class BanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
			               BankAccountRepository bankAccountRepository,
			               AccountOperationRepository accountOperationRepository) {
		return args-> {
			Stream.of("Cheikh","Jacque","Aicha").forEach(name->{
				Customer customer=new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(cust->{
				CurrentAccount currentAccount=new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*90000);
				currentAccount.setCreateAt(new Date());
				currentAccount.setStatus(AccountStatus.CREATED);
				currentAccount.setCustomer(cust);
				currentAccount.setOverDrafs(90000);
			    bankAccountRepository.save(currentAccount);
			    
			    SavingAccount savingAccount=new SavingAccount();
			    savingAccount.setId(UUID.randomUUID().toString());
			    savingAccount.setBalance(Math.random()*90000);
			    savingAccount.setCreateAt(new Date());
			    savingAccount.setStatus(AccountStatus.CREATED);
			    savingAccount.setCustomer(cust);
			    savingAccount.setInterestRate(5.5);
			    bankAccountRepository.save(savingAccount);
			    
						
			});
			
			bankAccountRepository.findAll().forEach(acc->{
				for(int i=0;i<5;i++) {
					AccountOperation accountOperation=new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setAmount(Math.random()*12000);
					accountOperation.setType(Math.random()>0.5?OperationType.DEBIT:OperationType.CREDIT);
					accountOperation.setBankAccount(acc);
					accountOperationRepository.save(accountOperation);
				}
			});
		};
	}

}
