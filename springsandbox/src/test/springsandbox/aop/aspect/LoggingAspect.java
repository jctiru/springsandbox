package test.springsandbox.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import test.springsandbox.aop.entity.Account;

@Aspect
@Component
@Order(3)
public class LoggingAspect {

	// @Before("execution(public void
	// test.springsandbox.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(* addAccount(test.springsandbox.aop.entity.Account))")
	@Before("test.springsandbox.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n======>>> Executing @Before advice on method");
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			System.out.println(arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}

}
