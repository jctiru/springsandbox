package test.springsandbox.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
		
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// Add init method
	public void doInitMethod() {
		System.out.println("TrackCoach: inside method doInitMethod");
	}
	
	// Add destroy method
	public void doDestroyMethod() {
		System.out.println("TrackCoach: inside method doDestroyMethod");
	}

}
