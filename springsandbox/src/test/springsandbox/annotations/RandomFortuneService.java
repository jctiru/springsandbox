package test.springsandbox.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Random 1",
			"Random 2",
			"Random 3"
	};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index] + " fortune service";
	}

}
