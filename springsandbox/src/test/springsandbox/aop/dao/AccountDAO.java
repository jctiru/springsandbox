package test.springsandbox.aop.dao;

import org.springframework.stereotype.Component;

import test.springsandbox.aop.entity.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(getClass() + ": Add account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Do work.");
		return true;
	}

}
