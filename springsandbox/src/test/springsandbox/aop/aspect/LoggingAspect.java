package test.springsandbox.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// Add all related advices for logging

	/*
	 * Pointcut expression: execution(modifiers-pattern? return-type-pattern
	 * declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	 */

	@Pointcut("execution(* test.springsandbox.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* test.springsandbox.aop.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* test.springsandbox.aop.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	// @Before("execution(public void
	// test.springsandbox.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(* addAccount(test.springsandbox.aop.entity.Account))")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n======>>> Performing API analytics");
	}

}
