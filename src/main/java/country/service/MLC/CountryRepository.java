package country.service.MLC;

import Bean.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
@Component

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
