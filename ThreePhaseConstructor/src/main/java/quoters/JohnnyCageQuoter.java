package quoters;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Profiling
public class JohnnyCageQuoter implements Quoter{
	
	@Value("Those were $500 sunglasses, asshole!!!")
	private String message;
	
	@InjectRandomInt(min=1, max=3)
	private int repeat;
	
	public JohnnyCageQuoter() {
		System.out.println("Phase 1");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Phase 2");
	}
	
	@Override
	@PostProxy
	public void sayQoute() {
		System.out.println("Phase 3");
		for(int i = 0; i<repeat; i++) {
			System.out.println(message);
		}
	}
	
}
