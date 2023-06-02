package api.springapistarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringApiStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiStarterApplication.class, args);
	}

}
