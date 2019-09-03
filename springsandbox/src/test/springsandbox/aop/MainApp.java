package test.springsandbox.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.springsandbox.aop.dao.AccountDAO;
import test.springsandbox.aop.dao.MembershipDAO;
import test.springsandbox.aop.entity.Account;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account account = new Account();
		account.setName("John");
		account.setLevel("Diamond");
		accountDAO.addAccount(account, true);
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		accountDAO.doWork();
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.goToSleep();

		context.close();
	}

}
