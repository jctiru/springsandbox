package test.springsandbox.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.springsandbox.aop.dao.AccountDAO;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount();
		context.close();
	}

}
