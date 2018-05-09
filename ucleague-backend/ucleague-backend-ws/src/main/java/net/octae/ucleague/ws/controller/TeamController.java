package net.octae.ucleague.ws.controller;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Championship;
import net.octae.ucleague.domain.Country;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.domain.TeamInput;
import net.octae.ucleague.ws.dto.ChampionshipDTO;
import net.octae.ucleague.ws.dto.TeamDTO;
import net.octae.ucleague.ws.dto.TeamInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Team controller.
 */
@RestController
@RequestMapping(path = "/team")
public class TeamController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeamService teamService;

    /**
     * Gets paged teams.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the teams
     */
    @GetMapping
    public Page<TeamDTO> getPagedTeams(@RequestParam(required = false) String name, Pageable pageable) {

        Page<Team> teams = teamService.getTeams(name, pageable);
        return entityConverter.convert(teams, TeamDTO.class);
    }

    /**
     * Gets team.
     *
     * @param teamId the team id
     * @return the team
     */
    @GetMapping(path = "/{teamId}")
    public TeamDTO getTeam(@PathVariable Long teamId) {
        return entityConverter.convert(teamService.getTeam(teamId), TeamDTO.class);
    }

    /**
     * Create team team dto.
     *
     * @param teamInputDTO the team input dto
     * @return the team dto
     */
    @PostMapping
    public TeamDTO createTeam(@Valid @RequestBody TeamInputDTO teamInputDTO) {

        TeamInput teamInput = entityConverter.convert(teamInputDTO,TeamInput.class);
        return entityConverter.convert(teamService.createTeam(teamInput), TeamDTO.class);
    }

    /**
     * Update team.
     *
     * @param teamId       the team id
     * @param teamInputDTO the team input dto
     */
    @PutMapping(path = "/{teamId}")
    public void updateTeam(@PathVariable Long teamId, @Valid @RequestBody TeamInputDTO teamInputDTO) {
        TeamInput teamInput = entityConverter.convert(teamInputDTO,TeamInput.class);
        teamService.updateTeam(teamId, teamInput);
    }

    /**
     * Gets championships.
     *
     * @param teamId the team id
     * @return the championships
     */
    @GetMapping(path = "/{teamId}/championship")
    public List<ChampionshipDTO> getChampionships(@PathVariable Long teamId) {
        Team team = teamService.getTeam(teamId);
        return entityConverter.convert(team.getChampionships(), ChampionshipDTO.class);
    }

    /**
     * Add championship.
     *
     * @param teamId the team id
     * @param year   the year
     */
    @PostMapping(path = "/{teamId}/championship/{year}")
    public void addChampionship(@PathVariable Long teamId, @PathVariable Long year) {
        teamService.addChampionship(teamId, year);
    }

    /**
     * Delete championship.
     *
     * @param teamId the team id
     * @param year   the year
     */
    @DeleteMapping(path = "/{teamId}/championship/{year}")
    public void deleteChampionship(@PathVariable Long teamId, @PathVariable Long year) {
        teamService.deleteChampionship(teamId, year);
    }

    /**
     * Update championships.
     *
     * @param teamId the team id
     * @param championships the championships
     */
    @PutMapping(path = "/{teamId}/championship")
    public void updateChampionship(@PathVariable Long teamId, @RequestBody List<ChampionshipDTO> championships) {
        teamService.updateChampionships(teamId, entityConverter.convert(championships, Championship.class));
    }

    /**
     * Delete team.
     *
     * @param teamId the team id
     */
    @DeleteMapping(path = "/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }
}
