package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.configuration.PersistenceConfigurationTest;
import net.octae.ucleague.persistence.entity.CountryEntity;
import net.octae.ucleague.persistence.entity.TeamEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfigurationTest.class)
public class TeamRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void findByCategoryIdInWithSuccess() {

        // Arrange
        CountryEntity country1 = new CountryEntity("Country 1");
        entityManager.persist(country1);
        entityManager.flush();

        TeamEntity team1 = new TeamEntity("qwerty");
        team1.setCountry(country1);
        entityManager.persist(team1);

        TeamEntity team2 = new TeamEntity("azerty");
        team2.setCountry(country1);
        entityManager.persist(team2);

        entityManager.flush();

        // Act
        Page<TeamEntity> teams = teamRepository.findByNameIgnoreCaseContaining(team1.getName(), Pageable.unpaged());

        // Assert
        assertEquals("Wrong teams size", 1, teams.getTotalElements());
        assertThat(teams, contains(
                hasProperty("name", is(team1.getName()))));
    }
}