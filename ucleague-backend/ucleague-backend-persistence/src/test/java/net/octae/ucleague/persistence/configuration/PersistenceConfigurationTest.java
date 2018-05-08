package net.octae.ucleague.persistence.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = "net.octae.ucleague.persistence")
public class PersistenceConfigurationTest {
}
