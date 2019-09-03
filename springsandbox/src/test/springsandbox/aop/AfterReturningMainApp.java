package test.springsandbox.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.springsandbox.aop.dao.AccountDAO;
import test.springsandbox.aop.entity.Account;

public class AfterReturningMainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Accounts: " + accounts);

		context.close();
	}

}
