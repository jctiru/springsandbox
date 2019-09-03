package test.springsandbox.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspect {

	// @Before("execution(public void
	// test.springsandbox.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(* addAccount(test.springsandbox.aop.entity.Account))")
	@Before("test.springsandbox.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}

}
