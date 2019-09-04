package test.springsandbox.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import test.springsandbox.aop.entity.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": getName().");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName().");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode().");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode().");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean isVip) {
		System.out.println(getClass() + ": Add account.");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": Do work.");
		return true;
	}

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account("Zidane", "Silver");
		Account account2 = new Account("Tidus", "Platinum");
		Account account3 = new Account("Cecil", "Gold");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}

	public List<Account> findAccounts(boolean tripWire) {
		// Simulate exception
		if (tripWire) {
			throw new RuntimeException("No capes!");
		}
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account("Zidane", "Silver");
		Account account2 = new Account("Tidus", "Platinum");
		Account account3 = new Account("Cecil", "Gold");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}

}
