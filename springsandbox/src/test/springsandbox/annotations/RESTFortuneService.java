package test.springsandbox.annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "REST fortune service";
	}

}
