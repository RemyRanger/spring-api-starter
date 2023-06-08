package api.springapistarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class SpringApiStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiStarterApplication.class, args);
	}

    @Bean
    RestTemplate getRestTemplate() {
		/* Replace default HttpURLConnection implementation which throws IO execption on 4xx status code */
		final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        return new RestTemplate(factory);
    }

}
