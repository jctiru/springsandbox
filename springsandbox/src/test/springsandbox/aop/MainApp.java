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

		accountDAO.addAccount(new Account());
		accountDAO.doWork();
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.goToSleep();

		context.close();
	}

}
