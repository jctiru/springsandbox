package test.springsandbox.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// Add all related advices for logging

	/*
	 * Pointcut expression: execution(modifiers-pattern? return-type-pattern
	 * declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	 */

	// @Before("execution(public void test.springsandbox.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(* addAccount(test.springsandbox.aop.entity.Account))")
	@Before("execution(* test.springsandbox.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}

}
