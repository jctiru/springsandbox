package test.springsandbox.aop.dao;

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

	public void addAccount(Account account) {
		System.out.println(getClass() + ": Add account.");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": Do work.");
		return true;
	}

}
