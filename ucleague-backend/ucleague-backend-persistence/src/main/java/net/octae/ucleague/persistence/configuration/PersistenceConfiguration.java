package net.octae.ucleague.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "net.octae.ucleague.persistence.entity")
@EnableJpaRepositories(basePackages = "net.octae.ucleague.persistence.repository")
public class PersistenceConfiguration {
}
