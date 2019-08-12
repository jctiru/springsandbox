package test.springsandbox.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class TennisCoach implements Coach {

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// @Autowired
	private FortuneService fortuneService;

	/*
	 * @Autowired
	 * public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService;
	 * }
	 */

	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// Init method
	@PostConstruct
	public void doInitMethod() {
		System.out.println("Inside TennisCoach doInitMethod");
	}
	
	// Destroy method
	@PreDestroy
	public void doPreDestroyMethod() {
		System.out.println("Inside TennisCoach doPreDestroyMethod");
	}

}
