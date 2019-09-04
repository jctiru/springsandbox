package test.springsandbox.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	@AfterReturning(pointcut = "execution(* test.springsandbox.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning advice on method: " + method);
		System.out.println("\n======>>> result: " + result);
		result.get(0).setName("Terra");
	}

	@AfterThrowing(pointcut = "execution(* test.springsandbox.aop.dao.AccountDAO.findAccounts(..))", throwing = "e")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterThrowing advice on method: " + method);
		System.out.println("\n======>>> Exception: " + e);

	}

	@After("execution(* test.springsandbox.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @After (finally) advice on method: " + method);
	}

	@Around("execution(* test.springsandbox.aop.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @Around advice on method: " + method);
		long start = System.currentTimeMillis();
		Object result = null;

		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// result = "Major accident! Go alternate route!";
			// Rethrow exception
			throw e;
		}

		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("\n======>>> Duration: " + (duration / 1000.0) + " seconds");

		return result;
	}

}
