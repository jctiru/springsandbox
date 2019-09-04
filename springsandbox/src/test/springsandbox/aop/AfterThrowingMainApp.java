package test.springsandbox.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.springsandbox.aop.dao.AccountDAO;
import test.springsandbox.aop.entity.Account;

public class AfterThrowingMainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		System.out.println("Accounts: " + accounts);

		context.close();
	}

}
