package test.springsandbox.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	/*
	 * Pointcut expression: execution(modifiers-pattern? return-type-pattern
	 * declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	 */

	@Pointcut("execution(* test.springsandbox.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* test.springsandbox.aop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* test.springsandbox.aop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
