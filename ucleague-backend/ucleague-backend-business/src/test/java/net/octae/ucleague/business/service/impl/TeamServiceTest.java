package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.persistence.entity.TeamEntity;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    @Test
    public void getTeamsByNameWithSuccess() {

        // Arrange
        Long teamId = 1L;
        String serchBy = "qwerty";

        TeamEntity teamEntity = new TeamEntity(teamId);
        Page<TeamEntity> teamEntities = new PageImpl<>(Arrays.asList(teamEntity), Pageable.unpaged(), 1);
        when(teamRepository.findByNameIgnoreCaseContaining(eq(serchBy), any(Pageable.class))).thenReturn(teamEntities);

        Page<Team> teams = new PageImpl<>(Arrays.asList(new Team(teamId)), Pageable.unpaged(), 1);
        when(entityConverter.convert(any(Page.class), eq(Team.class))).thenReturn(teams);

        // Act
        Page<Team> result = teamService.getTeams(serchBy, Pageable.unpaged());

        // Assert
        assertNotNull("result is null", result);
        assertThat(result.getContent(), contains(
                hasProperty("id", is(teamId))));
        verify(teamRepository, times(1)).findByNameIgnoreCaseContaining(eq(serchBy), eq(Pageable.unpaged()));

    }

}