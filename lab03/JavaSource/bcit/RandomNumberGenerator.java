package bcit;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ConversationScoped

public class RandomNumberGenerator implements Serializable {
	
	private java.util.Random random = new Random(System.currentTimeMillis());
	
	@Produces
	@Named
	@bcit.Random 
	int getRandomNumber() {
		return random.nextInt(100);
	}
}
