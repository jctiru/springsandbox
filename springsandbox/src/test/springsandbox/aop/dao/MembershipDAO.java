package test.springsandbox.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": Add account.");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": Go to sleep.");
	}
	
}
