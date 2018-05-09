package net.octae.ucleague.ws.controller;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.ws.dto.TeamDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntityConverter entityConverter;

    @MockBean
    private TeamService teamService;

    @Test
    public void getTeamWithSuccess() throws Exception {

        // Arrange
        Team team = new Team(1L);
        when(teamService.getTeam(team.getId())).thenReturn(team);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(1L);
        when(entityConverter.convert(any(Team.class), eq(TeamDTO.class))).thenReturn(teamDTO);

        // Act and assert
        mockMvc.perform(get("/team/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(teamDTO.getId().intValue())));
    }

}