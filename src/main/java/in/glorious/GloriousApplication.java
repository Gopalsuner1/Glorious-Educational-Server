package in.glorious;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GloriousApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloriousApplication.class, args);
	}

}
