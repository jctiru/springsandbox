package test.springsandbox.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// Create object
		Coach theCoach = new TrackCoach();

		// Use object
		System.out.println(theCoach.getDailyWorkout());
	}

}
