package country.service.MLC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"country.service.MLC.CountryRepository"})
@EntityScan("country.service.MLC.CountryRepository")
public class MlcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlcApplication.class, args);
	}

}
